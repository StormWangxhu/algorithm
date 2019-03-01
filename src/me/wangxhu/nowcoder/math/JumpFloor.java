package me.wangxhu.nowcoder.math;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-01 10:33
 * @Email: StormWangxhu@163.com
 * @Description: 分析：我们考虑最简单的情形:其中函数f为跳的方法
 * 如果只有1个台阶，那么显然只有一种跳法；如果是2级台阶，那么有2种跳法。
 * 假如我们先跳1个台阶，则剩下有 n-1 个台阶，跳法为 f(n-1) 次，假如我们先跳2个台阶，
 * 则剩下 n-2 阶，跳法为 f(n-2)；由此可以推出，对于一个n阶的楼梯，有以下这个跳台阶的公式：
 * f(n)=f(n-1)+f(n-2)  n>2
 */
public class JumpFloor {

    /**
     * 跳台阶问题的关系式和斐波那契数列的关系式是一样的
     * 389ms
     */
    static class Solution1 {

        public int JumpFloor(int target) {

            if (target <= 2) {
                return target;
            }

            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }


    /**
     * 动态规划
     * 19ms
     */
    static class Solution2 {

        public int JumpFloor(int target) {

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

    /**
     * 和只与前两个数有关
     * 17ms
     */
    static class Solution3 {

        public int JumpFloor(int target) {

            if (target <= 2) {
                return target;
            }

            int pre1 = 1, pre2 = 2;
            int result = 0;
            for (int i = 3; i <= target; i++) {
                result = pre1 + pre2;
                pre1 = pre2;
                pre2 = result;
            }
            return result;
        }
    }

}
