package me.wangxhu.demo_zuochengzuo.linkedlist;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-12 15:22
 * @Email: StormWangxhu@163.com
 * @Description: 最大值减去最小值小于或等于Num子数组的数量
 */
public class GetMaxMinNum {

    /**
     * 时间复杂度O（N^3）
     * 常规做法
     *
     * @param arr
     * @param num
     * @return
     */
    public static int getMaxMinNum(int[] arr, int num) {

        int res = 0;
        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {
                if (isValid(arr, start, end, num)) {
                    res++;
                }
            }
        }
        return res;
    }

    private static boolean isValid(int[] arr, int start, int end, int num) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        return max - min <= num;
    }
}
