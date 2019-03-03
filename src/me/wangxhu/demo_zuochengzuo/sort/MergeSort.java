package me.wangxhu.demo_zuochengzuo.sort;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-02 12:21
 * @Email: StormWangxhu@163.com
 * @Description: 归并排序
 * 时间复杂度： O(n * logN)
 * 空间复杂度： O（N）
 */
public class MergeSort {

    static class Solution {

        public static void mergeSort(int[] arr) {

            if (arr == null || arr.length < 2) {
                return;
            }

            sortProcess(arr, 0, arr.length);
        }

        private static void sortProcess(int[] arr, int L, int R) {

            if (L == R) {
                return;
            }

            int mid = L + ((R - L) >> 1);
            sortProcess(arr, L, mid);//左边部分排序   T(N/2)
            sortProcess(arr, mid + 1, R);  //右边部分排序   T(N/2)
            merge(arr, L, mid, R);  //再将排序好部分合并     O(N)
            // T(N)=2T(n/2)+O(N)
        }

        private static void merge(int[] arr, int L, int mid, int R) {
            int[] help = new int[R - L + 1];
            int i = 0;
            int p1 = L;
            int p2 = mid+1;
            while (p1 <= mid && p2 <= R) {
                help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];//谁小填谁，并往下移动
            }

            //两个必有且只有一个越界，把没有越界的拷贝到help数组中
            while (p1 <= mid) {
                help[i++] = arr[p1++];
            }
            while (p2 <= R) {
                help[i++] = arr[p2++];
            }

            for (i = 0; i < help.length; i++) {
                arr[L + i] = help[i];
            }
        }
    }
}
