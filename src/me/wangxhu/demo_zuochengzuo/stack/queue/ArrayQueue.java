package me.wangxhu.demo_zuochengzuo.stack.queue;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-03 16:21
 * @Email: StormWangxhu@163.com
 * @Description: 用数组实现固定大小的队列
 * 两个指针start end ,
 * size来解耦两个指针之间的关系.
 */
public class ArrayQueue {

    private Integer[] array;
    private Integer start;
    private Integer end;
    private Integer size;

    public ArrayQueue(int initSize) {
        if (initSize < 0) {
            throw new RuntimeException("The init is less than 0");
        }
        array = new Integer[initSize];
        start = 0;
        end = 0;
        size = 0;
    }


    public void push(int num) {
        if (size == array.length) {
            throw new RuntimeException("The queue is full");
        }
        size++;
        array[end] = num;
        end = end == array.length - 1 ? 0 : end + 1;
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[start];
    }

    public Integer poll() {
        if (size == 0) {
            throw new RuntimeException("the queue is impty");
        }
        size--;
        int tmp = start;//记录一下当前start位置
        start = start == array.length - 1 ? 0 : start + 1;
        return array[tmp];
    }
}
