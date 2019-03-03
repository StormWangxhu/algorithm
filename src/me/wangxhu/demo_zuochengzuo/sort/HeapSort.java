package me.wangxhu.demo_zuochengzuo.sort;


/**
 * @Author: StormWangxhu
 * @Time: 2019-03-03 09:44
 * @Email: StormWangxhu@163.com
 * @Description: 大根堆  时间复杂度： O（N * log N）
 */
public class HeapSort {

    static class Solution {

        public static void heapSort(int[] arr) {

            if (arr == null || arr.length < 2) {
                return;
            }

            for (int i = 0; i < arr.length; i++) {
                heapInsert(arr, i);
            }

            //上面步骤就是将一个数组变成大根堆的过程，整个数组变成大根堆后，将堆顶元素（即整个数组中最大的数）
            //和数组最后一个数进行交换。并将堆范围-1.
            int heapSize = arr.length;//堆中元素的个数，即数组长度
            swap(arr, 0, --heapSize);

            //然后重复进行，即不断将堆顶元素与数组最后一个位置数进行交换。
            while (heapSize > 0) {
                heapify(arr, 0, heapSize);//再调整出一个大根堆，再交换.g6
                swap(arr, 0, --heapSize);
            }
        }

        /**
         * heapInsert是从下往上调整的一个过程
         * heapInsert产生的结果也是一个大根堆.
         *
         * @param arr
         * @param index
         */
        public static void heapInsert(int[] arr, int index) {

            while (arr[index] > arr[(index - 1) / 2]) { // (index-1)/2 是父节点下标索引
                swap(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        /**
         * heapify 是一个值变小从上往下调整的过程
         * heapify过程产生的结果就是产生一个大根堆
         *
         * @param arr
         * @param index
         * @param heapSize
         */
        public static void heapify(int[] arr, int index, int heapSize) {
            int left = 2 * index + 1;  //当前节点的左孩子下标  left+1 为当前孩子右节点的下标
            while (left < heapSize) {
                //先左右孩子进行大小对比
                int largest = left + 1 < heapSize && arr[left + 1] > arr[left]   //右孩子不越界且右孩子和左孩子比较大小，左右孩子谁大谁就是largest
                        ? left + 1
                        : left;
                largest = arr[largest] > arr[index] ? largest : index;
                if (largest == index) {
                    break;
                }
                swap(arr, largest, index); // largest != index
                index = largest;
                left = index * 2 + 1;
            }
        }

        public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


}
