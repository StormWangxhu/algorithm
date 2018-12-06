package me.wangxhu.other;

import java.util.Arrays;

/**
 * <p>Created on 18-12-6</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * 堆排序
 */
public class HeapSort {

    public static void heapSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        //第一次建堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;//堆中元素的个数
        //第一次交换
        swap(arr, 0, --size);
        /**
         * 一直就是一个建堆和交换的过程
         * 建一次堆,交换一次(堆顶元素和堆最后一个元素交换,即数组第一位和最后一位交换),就完成一次排序
         */
        while (size > 0) {
            heapify(arr, 0, size);//建堆
            swap(arr, 0, --size);//交换
        }
    }


    /**
     * 作用：初始化堆：将待排序的数组转化成二叉堆。
     * @param arr　　待排序数组
     * @param index　　当前节点
     */
    public static void heapInsert(int[] arr, int index) {

        while (arr[(index - 1) / 2] < arr[index]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 在构建最大堆
     *
     * @param arr
     * @param index
     * @param size
     */
    public static void heapify(int[] arr, int index, int size) {

        int left = index * 2 + 1;
        // int right = index *2 +2 ;
        while (left < size) {
            /**
             * left+1表示右节点
             * 左节点和右节点比较,得出左右节点当中的最大的节点
             * 然后再和左右节点的根节点比较得出三个中的最大值
             *
             */
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;//得出左右节点最大的
            largest = arr[largest] > arr[index] ? largest : index; //和根节点比较得出最大的
            if (largest == index) {
                break;
            }
            swap(arr, largest, index); //根节点进行交换
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }


    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {

        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {

        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {

        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {

        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }


    static class HeapSort2 {

        /**
         * 建堆
         *
         * @param arrays          看做是完全二叉树
         * @param currentRootNode 当前节点位置
         * @param size            节点总数
         */
        public static void heapify1(int[] arrays, int currentRootNode, int size) {

            if (currentRootNode < size) {

                //左子树和右子树位置
                int left = 2 * currentRootNode + 1;
                int right = 2 * currentRootNode + 2;

                //把当前父节点看做是最大的
                int max = currentRootNode;

                if (left < size) {
                    //如果比当前根元素要大，记录它的位置
                    if (arrays[max] < arrays[left]) {
                        max = left;
                    }
                }

                if (right < size) {
                    //如果比当前根元素要大，记录它的位置
                    if (arrays[max] < arrays[right]) {
                        max = right;
                    }
                }

                //如果最大的不是根元素位置，那么就交换
                if (max != currentRootNode) {
                    int temp = arrays[max];
                    arrays[max] = arrays[currentRootNode];
                    arrays[currentRootNode] = temp;

                    //继续比较,直到完成一次建堆
                    heapify1(arrays, max, size);
                }

            }

        }


        /**
         * 完成一次建堆，最大值在堆的顶部(根节点)
         *
         * @param arrays
         * @param size
         */
        public static void maxHeapify(int[] arrays, int size) {

            // 从数组的尾部开始，直到第一个元素(角标为0)
            for (int i = size - 1; i >= 0; i--) {
                heapify1(arrays, i, size);
            }
        }


        /**
         * 不断建堆,让数组中代码有序
         *
         * @param arrays
         */
        public static void HeapSort1(int[] arrays) {

            int size = arrays.length;

            for (int i = 0; i < size; i++) {
                maxHeapify(arrays, arrays.length - i);
                int temp = arrays[0];
                arrays[0] = arrays[(arrays.length - 1) - i];
                arrays[(arrays.length - 1) - i] = temp;
            }
        }


        // for test
        public static void main(String[] args) {

            int testTime = 500000;
            int maxSize = 100;
            int maxValue = 100;
            boolean succeed = true;
            for (int i = 0; i < testTime; i++) {
                int[] arr1 = generateRandomArray(maxSize, maxValue);
                int[] arr2 = copyArray(arr1);
                HeapSort1(arr1);
                comparator(arr2);
                if (!isEqual(arr1, arr2)) {
                    succeed = false;
                    break;
                }
            }
            System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        }

    }
}
