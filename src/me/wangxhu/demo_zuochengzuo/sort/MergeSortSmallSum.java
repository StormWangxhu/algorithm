package me.wangxhu.demo_zuochengzuo.sort;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-02 13:12
 * @Email: StormWangxhu@163.com
 * @Description: 数组的最小和问题
 */
public class MergeSortSmallSum {

    static class Solution {

        public static int SmallSum(int[] arr) {

            if (arr == null || arr.length < 2) {
                return 0;
            }
            return mergeSort(arr, 0, arr.length - 1);
        }

        private static int mergeSort(int[] arr, int L, int R) {

            if (L == R) {
                return 0; //他本身，没有最小的了
            }

            int mid = L + ((R - L + 1) >> 1);
            //左边部分merge的最小和+右边部分merge的最小和+整体merge的最小和，他们之间是覆盖累加的关系
            return mergeSort(arr, L, mid)
                    + mergeSort(arr, mid + 1, R)
                    + merge(arr, L, mid, R);
        }

        //整体部分进行merge
        private static int merge(int[] arr, int L, int mid, int R) {
            int[] help = new int[R - L + 1];
            int i = 0;
            int p1 = L;
            int p2 = mid + 1;
            int sum = 0;

            while (p1 <= mid && p2 <= R) {
                sum += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;//就是看右边大于左边当前数的个数，即右边比当前数大的个数。(R - p2 + 1)为长度
                help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
            }

            while (p1 <= mid) {
                help[i++] = arr[p1++];
            }

            while (p2 <= R) {
                help[i++] = arr[p2++];
            }

            for (i = 0; i < arr.length; i++) {
                arr[L+i]=help[i];
            }
            return sum;

        }
    }
}
