package me.wangxhu.demo_zuochengzuo.stack;

import java.util.Stack;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-03 17:09
 * @Email: StormWangxhu@163.com
 * @Description: 实现栈的基本操作，并返回栈中的最小值
 */
public class MinStack {

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int num) {
        if (minStack.isEmpty()) {
            minStack.push(num);
        } else if (num < getMin()) {
            minStack.push(num);
        } else {
            int peek = minStack.peek();
            minStack.push(peek);
        }
        dataStack.push(num);

    }

    private int getMin() {
        if (this.minStack.isEmpty()) {
            throw new RuntimeException("The stack is empty");
        }
        return this.minStack.peek();
    }

    public int pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("The stack is empty");
        }
        minStack.pop();
        return dataStack.pop();
    }
}
