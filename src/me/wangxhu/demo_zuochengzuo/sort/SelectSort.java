package me.wangxhu.demo_zuochengzuo.sort;


/**
 * @Author: StormWangxhu
 * @Time: 2019-03-02 10:30
 * @Email: StormWangxhu@163.com
 * @Description: 选择排序
 * [0,n-1]位置上找一个最小的放在0位置上。
 * [1,n-1]位置上找一个最小的放在1位置上。
 * [2,n-1]位置上找一个最小的放在2位置上。
 */
public class SelectSort {

    static class Solution {

        public static void selectSort(int[] arr) {

            if (arr == null || arr.length < 2) {
                return;
            }

            for (int i = 0; i < arr.length - 1; i++) { //i 最大取 n-2
                int minIndex = i; //最小值初始值
                for (int j = i + 1; j < arr.length; j++) {
                    minIndex = arr[j] < arr[minIndex] ? j : minIndex;
                }
                swap(arr, i, minIndex);
            }
        }

        public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
