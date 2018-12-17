package me.wangxhu.leedcode.string;

import java.util.Stack;

/**
 * <p>Created on 18-12-17</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode344:反转字符串
 */
public class Question344 {

    /**
     * 用双针针来实现
     */
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


    /**
     * 用栈来实现反转
     */
    static class Solution1 {

        public String revertString(String s) {

            char[] arr = s.toCharArray();
            char[] newChars = new char[arr.length];
            Stack<Character> stack = new Stack<>();
            for (Character character : arr) {
                stack.push(character);
            }
            int index = 0;
            while (!stack.isEmpty()) {
                newChars[index++] = stack.pop();
            }
            return String.valueOf(newChars);
        }
    }
}
