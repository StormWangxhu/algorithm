package me.wangxhu.leedcode.math;

/**
 * <p>Created on 18-12-21</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * <p>
 * leetcode374: 猜数字大小
 * 难度级别：简单
 */

public class Question374 {

    static class Solution {

        public int guessNumber(int n) {

            int low = 1, high = n;
            while (true) {
                int mid = (low + (high - low) / 2);
                int result = guess(mid);
                if (result == -1) {
                    high = mid - 1;
                } else if (result == 1) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            }

        }
    }
}
