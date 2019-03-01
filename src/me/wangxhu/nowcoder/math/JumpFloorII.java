package me.wangxhu.nowcoder.math;

import java.util.Arrays;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-01 15:33
 * @Email: StormWangxhu@163.com
 * @Description: 变态跳台阶问题：
 * 青蛙可以向上跳一级台阶，也可以向上跳2级台阶。。。可以向上跳n级台阶
 * 公式推到：
 * f(n-1) = f(n-2)+f(n-3)+f(n-4)+...f(0)
 * f(n) = f(n-1)+f(n-2)+f(n-3)+...+_f(0)
 * <p>
 * 则：f(n)-f(n-1) = f(n-1)
 * 整理得： f(n)=2 * f(n-1)
 * <p>
 * 即：等比数列
 */
public class JumpFloorII {

    /**
     * 递归求解
     * 13ms
     */
    static class Solution1 {

        public int JumpFloorII(int target) {

            if (target <= 2) {
                return target;
            }

            return 2 * JumpFloorII(target - 1);
        }
    }


    /**
     * 动态规划求解
     * 17ms
     */
    static class Solution2 {

        public int JumpFloorII(int target) {

            if (target <= 2) {
                return target;
            }

            int[] dp = new int[target];
            Arrays.fill(dp,1);//填充数组的方法，即：将数组全部填充为1

            for (int i = 1; i <target ; i++) {
                for (int j = 0; j <i ; j++) {
                    dp[i]+=dp[j];
                }
            }

            return dp[target-1];
        }
    }
}
