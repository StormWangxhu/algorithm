package me.wangxhu.leedcode.dp;

/**
 * <p>Created on 18-12-3</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode70 : 爬楼梯
 * <p>
 * 难度级别: 简单
 * <p>
 * 动态规划
 */
public class Question70 {

    /**
     * 递归:该方法会超出时间限制  531ms
     * 时间复杂度 : O(2^n)
     */
    static class Solution {

        public int climbStairs(int n) {

            if (n < 0) {
                return 0;
            }
            if (n == 1 || n == 2) {
                return n;
            }
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }


    /**
     * dp  19ms
     */
    static class Solution1 {

        public int climbStairs(int n) {

            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }


    /**
     * O(n)
     */
    static class Solution2 {

        public int climbStairs(int n) {

            if (n < 1) {
                return 0;
            }
            if (n == 1 || n == 2) {
                return n;
            }
            int pre1 = 1, pre2 = 1, cur = 0;
            for (int i = 2; i <= n; i++) {
                cur = pre1 + pre2;
                pre2 = pre1;
                pre1 = cur;
            }
            return cur;
        }
    }


    /**
     * O(n)
     */
    static class Solution3 {

        public int climbStairs(int n) {

            if (n < 0) {
                return 0;
            }
            if (n == 1 || n == 2) {
                return n;
            }
            int res = 2, pre = 1, tmp = 0;
            for (int i = 3; i <= n; i++) {
                tmp = res;
                res = res + pre;
                pre = tmp;
            }
            return tmp;
        }
    }
}
