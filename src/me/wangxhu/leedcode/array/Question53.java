package me.wangxhu.leedcode.array;

/**
 * <p>Created on 18-12-10</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode53.最大子序和
 * <p>
 * 即子数组的最大累加和问题
 * <p>
 * 难度级别:简单
 */
public class Question53 {

    /**
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     */
    static class Solution {

        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int max = Integer.MIN_VALUE;
            int cur = 0;
            for (int i = 0; i != nums.length; i++) {
                cur += nums[i];
                max = Math.max(max, cur);
                cur = cur < 0 ? 0 : cur;
            }
            return max;
        }
    }

    /**
     * 时间复杂度:O(N)
     * 空间复杂度:O(N)
     */
    static class Solution1 {

        public int maxSubArray(int[] nums) {
            int temp = nums[0];
            int sum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (temp > 0) {
                    temp += nums[i];
                } else {
                    temp = nums[i];
                }

                if (temp > sum)
                    sum = temp;
            }
            return sum;
        }
    }
}
