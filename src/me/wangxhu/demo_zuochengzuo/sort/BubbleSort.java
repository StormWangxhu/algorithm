package me.wangxhu.demo_zuochengzuo.sort;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-02 10:18
 * @Email: StormWangxhu@163.com
 * @Description: 冒泡排序:即将最大的数移到最后一个位置上后，数组缩小再进行。
 * 举例：第一遍：最大的数来到n位置上，在【0,n-1】再继续找。
 * 时间复杂度：O（N^2）
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
