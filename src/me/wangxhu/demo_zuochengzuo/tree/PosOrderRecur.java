package me.wangxhu.demo_zuochengzuo.tree;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-05 16:43
 * @Email: StormWangxhu@163.com
 * @Description: 后序遍历二叉树 递归实现
 */
public class PosOrderRecur {

    public void posOrderRecur(TreeNode head) {

        if (head == null) {
            return;
        }

        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.val);
    }
}
