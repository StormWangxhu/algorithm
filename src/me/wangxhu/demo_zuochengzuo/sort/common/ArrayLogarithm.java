package me.wangxhu.demo_zuochengzuo.sort.common;

import me.wangxhu.demo_zuochengzuo.sort.BubbleSort;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-02 11:22
 * @Email: StormWangxhu@163.com
 * @Description: 数组对数器
 */
public class ArrayLogarithm {


    //for test
    public static int[] generateRandomArray(int size, int value) {
        //Math.random() -> double [0,1)
        //(int) ((value+1)*Math.random()) -> [0,size) 整数
        //Math.random() ->[0,1)*7 ->[0,7) double
        //double -> int [0,6] ->int
        int[] array = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ((value + 1) * Math.random()) - (int) (value * Math.random());
        }
        return array;
    }

    //for test 系统提供绝对正确函数
    public static void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }


    //for test
    public static int[] copyArray(int[] arr) {

        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            res[i]= arr[i];
        }
        return res;
    }

    //for test
    public static boolean isEqual(int[] arr1,int[] arr2){

        if ((arr1==null&&arr2!=null)||arr1!=null&arr2==null){
            return false;
        }

        if (arr1==null&&arr2==null){
            return true;
        }

        if (arr1.length!=arr2.length){
            return false;
        }

        for (int i = 0; i <arr1.length ; i++) {
            if (arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }


    public static void printArray(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int testTime = 500000;
        int size = 10;
        int value = 100;
        boolean success = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(size, value);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            BubbleSort.bubbleSort(arr1);
            rightMethod(arr2);
            if (!isEqual(arr1, arr2)) {
                success = false;
                printArray(arr3);
                break;
            }
        }

        System.out.println(success ? "Nice,I LOVE YOU!" : "Oh NO!");

        int[] arr = generateRandomArray(size, value);
        printArray(arr);
        BubbleSort.bubbleSort(arr);
        printArray(arr);

    }
}
