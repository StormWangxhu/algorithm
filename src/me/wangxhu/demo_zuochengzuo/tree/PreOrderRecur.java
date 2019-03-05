package me.wangxhu.demo_zuochengzuo.tree;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-05 16:09
 * @Email: StormWangxhu@163.com
 * @Description: 先序遍历二叉树
 */
public class PreOrderRecur {

    public void preOrderRecur(TreeNode head) {

        if (head == null) {
            return;
        }

        System.out.print(head.val);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
}
