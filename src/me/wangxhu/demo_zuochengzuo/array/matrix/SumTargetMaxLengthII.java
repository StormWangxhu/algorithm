package me.wangxhu.demo_zuochengzuo.array.matrix;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-25 16:47
 * @Email: StormWangxhu@163.com
 * @Description: 未排序数组中累加和为给定值的最长子数组问题，其中数组中元素可正，可负，可0
 */
public class SumTargetMaxLengthII {

    public int getMaxLength(int[] arr, int k) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);//很重要，要把这个值提前存入到map中
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(i - map.get(sum - k), len);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return len;
    }
}
