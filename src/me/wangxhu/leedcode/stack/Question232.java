package me.wangxhu.leedcode.stack;

import java.util.Stack;

/**
 * <p>Created on 18-12-10</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode232.用栈实现队列
 */
public class Question232 {

    static class MyQueue {

        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public MyQueue() {
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }


        public void push(int x) {
            stackPush.push(x);
        }

        public int pop() {
            if (stackPush.isEmpty() && stackPop.isEmpty()) {
                throw new RuntimeException("stack is empty");
            } else if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }


        public int peek() {
            if (stackPush.isEmpty() && stackPop.isEmpty()) {
                throw new RuntimeException("stack is empty");
            } else if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }

        public boolean empty() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }

    }
}
