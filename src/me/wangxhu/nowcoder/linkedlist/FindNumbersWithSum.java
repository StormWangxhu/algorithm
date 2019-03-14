package me.wangxhu.nowcoder.linkedlist;

import java.util.ArrayList;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-14 23:54
 * @Email: StormWangxhu@163.com
 * @Description: 和为S的两个数字
 */
public class FindNumbersWithSum {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length < 2) {
            return list;
        }

        int R = array.length - 1;
        int L = 0;
        while (L < R) {
            if (array[L] + array[R] == sum) {
                list.add(array[L]);
                list.add(array[R]);
                return list;
            } else if (array[L] + array[R] < sum) {
                L++;
            } else {
                R--;
            }
        }
        return list;
    }
}
