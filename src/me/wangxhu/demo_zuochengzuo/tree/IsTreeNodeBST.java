package me.wangxhu.demo_zuochengzuo.tree;

import java.util.Stack;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-06 10:50
 * @Email: StormWangxhu@163.com
 * @Description: 判断一颗二叉树是否是搜索二叉树
 * 理论支持：一颗二叉树的中序遍历结果依次是递增的则为搜索二叉树，即改写二叉树的中序遍历
 */
public class IsTreeNodeBST {


    public boolean isTreeNodeBST(TreeNode head) {

        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            int max = Integer.MIN_VALUE;
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    //此处和中序遍历有差别，即弹出即打印处进行比较
                    head = stack.pop();
                    if (head.val > max) {
                        max = head.val;
                    } else {
                        return false;//一处不递增，就返回，不是搜索二叉树
                    }
                    head = head.right;
                }
            }
        }
        return true;
    }
}
