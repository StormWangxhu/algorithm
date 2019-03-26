package me.wangxhu.demo_zuochengzuo.array;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-26 10:54
 * @Email: StormWangxhu@163.com
 * @Description: 子数组的最大累加和问题
 * 时间复杂度：O（N）
 * 空间复杂度：O（1）
 */
public class SubMaxSum {

    public int maxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            max = Math.max(cur, max);
            cur = cur < 0 ? 0 : cur;//cur累加为负数就重新累加
        }
        return max;
    }

}
