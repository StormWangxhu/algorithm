package me.wangxhu.demo_zuochengzuo.linkedlist;

import java.util.LinkedList;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-13 09:34
 * @Email: StormWangxhu@163.com
 * @Description: 最大值减去最小值小于或等于Num子数组的数量
 * 使用双端队列，维护一个窗口最大值队列和窗口最小值队列
 * 时间复杂度：O（N）
 */
public class GetMaxMinNumII {

    public static int getMaxMinNumII(int[] arr, int num) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        LinkedList<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmin = new LinkedList<>();
        //l向左走一下，r就向右走一下
        int L = 0;//子数组范围的左边下标
        int R = 0;//子数组范围的右边下标
        int res = 0;//表示所有满足条件的子数组数量
        while (L < arr.length) {
            while (R < arr.length) {
                //维护一个窗口最小值队列
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[R]) {
                    qmin.pollLast();
                }
                qmin.addLast(R);

                //维护一个窗口最大值队列
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                    qmax.pollLast();
                }
                qmax.addLast(R);

                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                R++;//子数组右边界向右扩
            }
            //判断下标是否过期
            if (qmin.peekFirst() == L) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == L) {
                qmax.pollFirst();
            }
            res += R - L;
            L++;
        }
        return res;
    }
}
