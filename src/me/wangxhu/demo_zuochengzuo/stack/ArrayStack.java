package me.wangxhu.demo_zuochengzuo.stack;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-03 16:11
 * @Email: StormWangxhu@163.com
 * @Description: 用数组实现固定大小的栈
 */
public class ArrayStack {

    private int[] array;
    private int index;

    public ArrayStack(int initSize) {
        if (initSize < 0) {
            throw new RuntimeException("The init size is less than 0");
        }
        array = new int[initSize];
        index = 0;
    }

    public void push(int obj) {
        if (index == array.length) {
            throw new RuntimeException("The Stack is full");
        }
        array[index++] = obj;
    }

    public Integer peek() {
        if (index == 0) {
            return null;
        }
        return array[index - 1];
    }

    public Integer pop() {
        if (index == 0) {
            throw new RuntimeException("The stack is empty");
        }
        return array[--index];
    }
}
