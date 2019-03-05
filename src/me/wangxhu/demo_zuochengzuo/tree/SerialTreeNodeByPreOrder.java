package me.wangxhu.demo_zuochengzuo.tree;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-05 23:20
 * @Email: StormWangxhu@163.com
 * @Description: 先序序列化二叉树
 */
public class SerialTreeNodeByPreOrder {

    public String serialTreeNodeByPreOrder(TreeNode head) {

        if (head == null) {
            return "#!";
        }

        String res = head.val + "!"; //先将当前节点序列化
        res += serialTreeNodeByPreOrder(head.left);  //再加上左子树上的序列化
        res += serialTreeNodeByPreOrder(head.right);//再加上右子树的序列化
        return res;
    }

}
