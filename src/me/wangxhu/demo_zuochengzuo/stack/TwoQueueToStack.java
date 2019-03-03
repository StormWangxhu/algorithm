package me.wangxhu.demo_zuochengzuo.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-03 18:47
 * @Email: StormWangxhu@163.com
 * @Description: 两个队列结构实现栈
 */
public class TwoQueueToStack {

    private Queue<Integer> data;
    private Queue<Integer> help;

    public TwoQueueToStack() {
        data = new LinkedList<Integer>();
        help = new LinkedList<Integer>();
    }

    public void push(int num) {
        data.add(num);
    }

    public int peek() {
        if (data.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        while (data.size() != 1) {
            help.add(data.poll());
        }
        int res = data.poll();
        help.add(res);
        swap();//改变两个引用
        return res;
    }

    public int pop() {
        if (data.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        while (data.size() != 1) {
            help.add(data.poll());
        }
        int res = data.poll();
        swap();
        return res;
    }

    /**
     * 交换两个引用。使得两个队列来回倒
     */
    private void swap() {
        Queue<Integer> temp = data;
        data = help;
        help = temp;
    }


}
