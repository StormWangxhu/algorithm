package me.wangxhu.leedcode.array;

import java.util.Arrays;

/**
 * <p>Created on 18-12-10</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode153.寻找旋转排序数组中的最小值
 * <p>
 * 难度级别:中等
 */
public class Question153 {

    static class Solution {

        public int findMin(int[] arr) {

            if (arr == null || arr.length == 0)
                return 0;
            if (arr.length == 1)
                return arr[0];
            int L = 0, R = arr.length - 1;
            while (L < R) {
                int mid = L + (R - L) / 2;
                if (arr[L] <= arr[mid] && arr[L] > arr[R])
                    L = mid + 1;
                else
                    R = mid;
            }
            return arr[L];
        }
    }


    /**
     * 日鬼方法
     */
    static class Solution1{

        public int findMin(int[] arr){
            Arrays.sort(arr);
            return arr[0];
        }
    }
}
