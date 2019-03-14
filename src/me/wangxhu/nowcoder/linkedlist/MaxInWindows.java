package me.wangxhu.nowcoder.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-14 23:19
 * @Email: StormWangxhu@163.com
 * @Description: 滑动窗口最大值
 */
public class MaxInWindows {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> qmax = new LinkedList();
        if (num == null || size < 1 || num.length < size) {
            return list;
        }

        for (int i = 0; i < num.length; i++) {
            while (!qmax.isEmpty() && num[qmax.peekLast()] <= num[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - size) {
                qmax.pollFirst();
            }
            if (i >= size - 1) {
                list.add(num[qmax.peekFirst()]);
            }
        }
        return list;
    }
}
