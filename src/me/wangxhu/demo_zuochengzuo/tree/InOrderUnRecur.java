package me.wangxhu.demo_zuochengzuo.tree;

import java.util.Stack;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-05 19:24
 * @Email: StormWangxhu@163.com
 * @Description: 中序遍历 非递归实现 栈来实现
 * 原理：
 * 1.当前节点不为空，将其压入栈，节点向左走
 * 2.当前节点为空，从栈中拿出一个打印，节点向右走
 */
public class PosOrderUnRecur {

    public static void posOrderUnRecur(TreeNode head) {

        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.val + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }
}
