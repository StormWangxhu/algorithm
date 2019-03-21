package me.wangxhu.demo_zuochengzuo.dp;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-21 17:01
 * @Email: StormWangxhu@163.com
 * @Description: 用一张表
 */
public class ABWinMaxScoreDPII {

    public static int winMostScore(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int scores = p(arr, 0, arr.length - 1);
        return Math.max(scores, sum - scores);

    }

    private static int p(int[] arr, int i, int j) {

        if (i == j) {
            return arr[i];
        }

        if (i + 1 == j) {
            return Math.max(arr[i], arr[j]);
        }

        return Math.max(
                //i+1...j
                arr[i] + Math.min(p(arr, i + 2, j), p(arr, i + 1, j - 1)),//A选了最左边的数。对方可能拿剩下最左边和左右中的一个较大，A从剩下中拿一个较小者
                // i ...j-1
                arr[j] + Math.min(p(arr, i + 2, j - 1), p(arr, i, j - 2))
        );
    }
}
