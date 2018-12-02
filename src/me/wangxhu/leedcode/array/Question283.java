package me.wangxhu.leedcode.array;

/**
 * <p>Created on 18-12-2</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode283 移动零
 * <p>
 * 难度级别: 简单
 */
public class Question283 {

    static class Solution {

        public void moveZeroes(int[] nums) {

            int idx = 0;
            for (int num : nums) {
                if (num != 0) {
                    nums[idx++] = num;
                }
            }
            while (idx < nums.length) {
                nums[idx++] = 0;
            }
        }
    }
}
