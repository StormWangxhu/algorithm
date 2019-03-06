package me.wangxhu.demo_zuochengzuo.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-06 11:24
 * @Email: StormWangxhu@163.com
 * @Description: 判断一颗二叉树是否是完全二叉树
 * 判断逻辑：二叉树按层遍历，两个判断：
 * 1.如果一个节点有右孩子，但是没有左孩子，直接返回false。（因为：完全二叉树每一层从左往右依次堆齐。如果有右没左，绝不是完全二叉树。）
 * 2. 如果第一次发现当前节点并不是左右孩子都有（有左没右，左右都没有），那之后的节点必须都为叶子节点，否则返回false。
 * 对于一颗二叉树左右节点4种情况（1.左右都有，2.有左没右（其余都为叶子节点），3.有右没左（直接返回false），4.左右都没有（其余都为叶子节点））
 */
public class IsTreeNodeCBT {

    public boolean isTreeNodeCBT(TreeNode head) {

        if (head == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        boolean leaf = false;//表示是否开启了阶段（即条件2）
        TreeNode left = null;
        TreeNode right = null;
        queue.offer(head);//先向队列中添加一个节点
        while (!queue.isEmpty()) {
            head = queue.poll();//弹出一个节点
            //拿到这个节点的左孩子，右孩子
            left = head.left;
            right = head.right;

            //接下来进行条件判断,这个if包含2个标准判断
            if ((leaf && (left != null || right != null)//(leaf && (left != null || right != null) 开启了后序节点都是叶子节点阶段，后面每个节点左右孩子都必须是null，否则返回false
                    || (left == null && right != null))) {//(left == null && right != null) 条件1 直接false
                return false;
            }


            if (left != null) {
                queue.offer(left);
            }

            if (right != null) {
                queue.offer(right);
            }
            if (left == null || right == null) {
                leaf = true;
            }


            //和上面代码是等效的
//            if (left != null) {
//                queue.offer(left);
//            }
//
//            if (right != null) {
//                queue.offer(right);
//            }else {
//                leaf =true;//为什么右孩子为null时就开启，因为左孩子为Null时即条件1，已经return了。
//            }

        }
        return true;
    }

}
