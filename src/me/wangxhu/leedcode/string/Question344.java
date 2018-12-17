package me.wangxhu.leedcode.string;

/**
 * <p>Created on 18-12-17</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode344:反转字符串
 */
public class Question344 {

    static class Solution {

        public String revertString(String s) {

            char[] arr = s.toCharArray();
            int start = 0;
            int end = arr.length - 1;
            char temp;
            while (start < end) {
                temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }

            return String.valueOf(arr);
        }
    }
}
