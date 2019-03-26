package me.wangxhu.demo_zuochengzuo.stack;

import java.util.Stack;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-26 09:21
 * @Email: StormWangxhu@163.com
 * @Description: 用递归函数和栈操作逆序一个栈
 */
public class ReverseStack {

    /**
     * 逆序一个栈
     *
     * @param stack
     */
    public static void reverse(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    /**
     * 删除并返回栈底最后一个元素
     *
     * @param stack
     * @return
     */
    private static int getAndRemoveLastElement(Stack<Integer> stack) {

        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }

    }


}
