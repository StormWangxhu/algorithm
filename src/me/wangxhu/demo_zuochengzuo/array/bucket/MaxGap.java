package me.wangxhu.demo_zuochengzuo.array.bucket;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-03 15:07
 * @Email: StormWangxhu@163.com
 * @Description: 求排序数组中相邻两数差值的最大值
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O（N），
 * 且要求不能用基于比较的排序。
 */
public class MaxGap {

    static class Solution {

        public static int maxGap(int[] arr) {

            if (arr == null || arr.length < 2) {
                return 0;
            }

            int len = arr.length;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
            }

            if (max == min) {
                return 0;
            }

            //三个数组长度都为n+1,每个桶的三个信息，即最大值，最小值以及是否有数据
            boolean[] hasNum = new boolean[len + 1];
            int[] maxs = new int[len + 1];
            int[] mins = new int[len + 1];
            int bid = 0;//桶的编号
            for (int i = 0; i < len; i++) {
                bid = bucket(arr[i], len, min, max);//确定几号桶
                mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
                maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
                hasNum[bid] = true;
            }
            int res = 0;
            int lastMax = maxs[0];//0号桶最大值
            int i = 1;
            for (; i <= len; i++) {
                if (hasNum[i]) {
                    res = Math.max(res, mins[i] - lastMax);//这个桶的最小减去上一个相邻最近非空桶的最大值。
                    lastMax = maxs[i];
                }
            }
            return res;
        }


        /**
         * 返回桶的编号
         * @param num
         * @param len
         * @param min
         * @param max
         * @return
         */
        private static int bucket(long num, long len, long min, long max) {
            return (int) ((num - min) * len / (max - min));
        }
    }


}
