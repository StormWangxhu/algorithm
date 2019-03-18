package me.wangxhu.bytedance;

import java.util.Scanner;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-16 10:06
 * @Email: StormWangxhu@163.com
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[]{1, 4, 16, 64};
        int R = arr.length;
        int CAim = 1024 - N;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[R][CAim + 1];
        for (int i = 1; i <= CAim; i++) {
            dp[0][i] = max;
            if (i - arr[0] >= 0 && dp[0][i - arr[0]] != max) {
                dp[0][i] = dp[0][i - arr[0]] + 1;
            }
        }
        int left = 0;
        for (int i = 1; i < R; i++) {
            for (int j = 1; j <= CAim; j++) {
                left = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
                    left = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }
        System.out.println(dp[R - 1][CAim] != max ? dp[R - 1][CAim] : -1);

    }
}
