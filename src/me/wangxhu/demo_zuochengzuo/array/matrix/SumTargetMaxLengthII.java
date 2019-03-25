package me.wangxhu.demo_zuochengzuo.array.matrix;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-25 16:47
 * @Email: StormWangxhu@163.com
 * @Description: 未排序数组中累加和为给定值的最长子数组问题，其中数组中元素可正，可负，可0
 * 时间复杂度：O（N）
 * 空间复杂度：O（N）
 */
public class SumTargetMaxLengthII {

    public int getMaxLength(int[] arr, int k) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();//key:表示从arr中最左边开始累加过程中出现的sum值，value：表示sum值最早出现的位置。
        map.put(0, -1);//很重要，要把这个值提前存入到map中
        int len = 0;//len表示累加和为k的最长子数组长度
        int sum = 0;//sum表示从位置0开始一直累加到到位置i的数组和
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
