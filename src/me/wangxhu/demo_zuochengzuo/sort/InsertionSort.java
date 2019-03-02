package me.wangxhu.demo_zuochengzuo.sort;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-02 10:50
 * @Email: StormWangxhu@163.com
 * @Description: 插入排序：往有序的数组中插
 * 原理：即将一个数插入已经排好序的数中
 * [0,0]
 * [0,1]
 * [0,2]
 * 打牌
 * <p>
 * 时间复杂度：O（N^2）
 */
public class InsertionSort {

    static class Solution {

        public static void insertSort(int[] arr) {

            if (arr == null || arr.length < 2) {
                return;
            }

            for (int i = 1; i < arr.length; i++) {
                for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {//从右向左依次比较并交换
                    swap(arr, j, j + 1);
                }
            }

        }

        public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
