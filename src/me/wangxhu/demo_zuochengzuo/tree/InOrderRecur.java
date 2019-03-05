package me.wangxhu.demo_zuochengzuo.tree;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-05 16:39
 * @Email: StormWangxhu@163.com
 * @Description: 中序遍历二叉树
 */
public class InOrderRecur {

    public void inOrderRecur(TreeNode head) {

        if (head == null) {
            return;
        }

        inOrderRecur(head.left);
        System.out.print(head.val);
        inOrderRecur(head.right);
    }
}
