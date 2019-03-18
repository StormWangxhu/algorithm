package me.wangxhu.nowcoder.array;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-18 17:06
 * @Email: StormWangxhu@163.com
 * @Description: 给一个数组，返回它的最大连续子序列的和
 * 即：子数组的最大累加和问题
 */
public class FindGreatestSumOfSubArray {

    public int FindGreatestSumOfSubArray(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i != array.length; i++) {
            cur += array[i];
            max = Math.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }
}
