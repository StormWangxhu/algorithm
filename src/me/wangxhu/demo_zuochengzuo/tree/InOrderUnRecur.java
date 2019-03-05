package me.wangxhu.demo_zuochengzuo.tree;

import java.util.Stack;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-05 17:13
 * @Email: StormWangxhu@163.com
 * @Description: 先序非递归实现 栈来实现
 */
public class InOrderUnRecur {

    public static void preOrderUnRecur(TreeNode head) {

        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.val);
                if (head.right != null) {
                    stack.add(head.right);
                }
                if (head.left != null) {
                    stack.add(head.left);
                }
            }
        }
        System.out.println();
    }
}
