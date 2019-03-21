package me.wangxhu.demo_zuochengzuo.array;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-21 15:57
 * @Email: StormWangxhu@163.com
 * @Description: 预测赢家，递归改动态规划
 */
public class ABWinMaxScoreDP {

    public static int winMostScore(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];//二维数组在默认初始化时为0
        for (int j = 0; j < arr.length; j++) {
            f[j][j] = arr[j];//将f表对角线设置好f(0,0)位置就是arr[0]的值
            for (int i = j - 1; i >= 0; i--) {//从对角线往上依次填
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }
}
