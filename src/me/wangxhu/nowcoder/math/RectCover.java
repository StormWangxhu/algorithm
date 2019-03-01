package me.wangxhu.nowcoder.math;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-01 11:25
 * @Email: StormWangxhu@163.com
 * @Description: 矩形覆盖问题：
 * f(1)=1,f(2)=2.
 * f(n)= f(n-1)+f(n-2)  n>2
 */

public class RectCover {

    /**
     * 使用递归求解
     */
    static class Solution1 {

        public int RectCover(int target) {

            if (target <= 2) {
                return target;
            }

            return RectCover(target - 1) + RectCover(target - 2);
        }
    }

    static class Solution2 {

        public int RectCover(int target) {

            if (target <= 2) {
                return target;
            }

            int[] dp = new int[target + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= target; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[target];
        }
    }


    static class Solution3 {

        public int RectCover(int target) {

            if (target <= 2) {
                return target;
            }


            int pre1 = 1, pre2 = 2;
            int result = 0;
            for (int i = 3; i <= result; i++) {
                result = pre1 + pre2;
                pre1 = pre2;
                pre2 = result;
            }
            return result;
        }
    }
}
