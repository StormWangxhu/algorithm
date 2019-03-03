package me.wangxhu.demo_zuochengzuo.stack;

import java.util.Stack;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-03 17:47
 * @Email: StormWangxhu@163.com
 * @Description: 两个栈实现队列
 */
public class TwoStackToQueue {

    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStackToQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void add(int num) {
        stackPush.push(num);
    }

    public int poll() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("The queue is empty");
        }

        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("The queue is empty");
        }

        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }

        return stackPop.peek();
    }

}
