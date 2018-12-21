package me.wangxhu.leedcode.math;

/**
 * <p>Created on 18-12-18</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode69.求x的平方根
 * <p>
 * 知识点：二分查找，数学
 * leetcode704有关
 */
public class Question69 {

    static class Solution {

        public int mySqrt(int x) {

            int low = 0, high = x;
            while (low <= high) {
                long mid = (low + high) / 2;
                if (mid * mid > x) {
                    high = (int) (mid - 1);
                } else if (mid * mid < x) {
                    low = (int) (mid + 1);
                } else {
                    return (int) mid;
                }
            }

            return high;
        }
    }
}
