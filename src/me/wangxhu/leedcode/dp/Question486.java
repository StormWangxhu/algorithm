package me.wangxhu.leedcode.dp;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-21 16:18
 * @Email: StormWangxhu@163.com
 * @Description: 预测赢家  耗时6ms  ，使用递归耗时96ms
 */
public class Question486 {

    public boolean PredictTheWinner(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        int[][] f = new int[nums.length][nums.length];
        int[][] s = new int[nums.length][nums.length];

        for (int j = 0; j < nums.length; j++) {
            f[j][j] = nums[j];
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(nums[i] + s[i + 1][j], nums[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return f[0][nums.length - 1] == Math.max(f[0][nums.length - 1], s[0][nums.length - 1]);
    }
}
