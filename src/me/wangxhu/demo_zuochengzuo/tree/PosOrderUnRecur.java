package me.wangxhu.demo_zuochengzuo.tree;

import java.util.Stack;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-05 20:02
 * @Email: StormWangxhu@163.com
 * @Description: 后序遍历 非递归实现  准备两个栈
 */
public class PosOrderUnRecur {

    public static void posOrderUnRecor(TreeNode head) {

        if (head != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }

                if (head.right != null) {
                    stack1.push(head.right);
                }

            }

            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().val);
            }
        }
        System.out.println();
    }
}
