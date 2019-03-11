package me.wangxhu.demo_zuochengzuo.linkedlist;

import java.util.LinkedList;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-11 20:58
 * @Email: StormWangxhu@163.com
 * @Description: 生成窗口最大值数组
 */
public class GetMaxWindow {

    public int[] getMaxWindow(int[] arr, int w) {

        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }

        LinkedList<Integer> pmax = new LinkedList();//双端队列
        int[] res = new int[arr.length - w + 1];//结果数组
        int index = 0;//结果数组中下标

        for (int i = 0; i < arr.length; i++) {
            while (!pmax.isEmpty() && arr[pmax.peekLast()] <= arr[i]) {
                pmax.pollLast();
            }
            pmax.addLast(i);

            if (pmax.peekFirst() == i - w) {
                pmax.pollFirst();
            }
            if (i > w - 1) {
                res[index++] = arr[pmax.pollFirst()];
            }
        }
        return res;
    }
}
