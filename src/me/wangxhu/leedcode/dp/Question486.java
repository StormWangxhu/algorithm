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
        int[][] s = new int[nums.length][nums.length];//s表初始化时就全部是0

        for (int j = 0; j < nums.length; j++) {//横着走，从最上最左往右走
            f[j][j] = nums[j];//初始化f表对角线
            for (int i = j - 1; i >= 0; i--) {//从对角线处向上向右走
                //两个表相互依赖
                f[i][j] = Math.max(nums[i] + s[i + 1][j], nums[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return f[0][nums.length - 1] == Math.max(f[0][nums.length - 1], s[0][nums.length - 1]);//返回两个表中最右上角的值中的最大者
    }
}
