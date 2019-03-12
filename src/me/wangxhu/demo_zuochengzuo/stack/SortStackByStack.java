package me.wangxhu.demo_zuochengzuo.stack;

import java.util.Stack;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-12 11:37
 * @Email: StormWangxhu@163.com
 * @Description: 用一个栈实现另一个栈的排序
 */
public class SortStackByStack {

    public static void sortStackByStack(Stack<Integer> stack) {

        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }

        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
