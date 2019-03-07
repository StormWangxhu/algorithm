package me.wangxhu.demo_zuochengzuo.greedy;

import java.util.PriorityQueue;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-07 16:43
 * @Email: StormWangxhu@163.com
 * @Description: 贪心问题
 * 分金条问题 ，即代价最小的问题
 */
public class LessMoney {

    public int lessMoney(int[] arr) {
        //优先级队列，即堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }

        int sum = 0;
        int cur = 0;
        while (priorityQueue.size() > 1) {//直到堆里只剩下一个
            cur = priorityQueue.poll() + priorityQueue.poll(); //一次拿两个
            sum += cur;
            priorityQueue.add(cur);//将新生成再放进堆里
        }
        return sum;
    }
}
