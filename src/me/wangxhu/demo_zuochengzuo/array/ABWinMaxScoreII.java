package me.wangxhu.demo_zuochengzuo.array;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-21 11:05
 * @Email: StormWangxhu@163.com
 * @Description:
 */
public class ABWinMaxScoreII {

    public static int winMostScore(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int fValue = f(arr, 0, arr.length - 1);
        return Math.max(fValue, sum - fValue);
    }

    private static int f(int[] arr, int i, int j) {

        if (i == j) {
            return arr[j];
        }

        return Math.max(arr[i] + f(arr, i + 1, j), arr[j] + f(arr, i, j - 1));
    }
}
