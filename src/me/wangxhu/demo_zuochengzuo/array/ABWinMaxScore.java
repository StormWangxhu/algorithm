package me.wangxhu.demo_zuochengzuo.array;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-21 10:28
 * @Email: StormWangxhu@163.com
 * @Description: A, B两个玩家获得最多的分数
 * A，先拿数组中左边或者右边中的一个
 * B再拿剩下中左边或者右边中的一个。
 * AB个体都绝对理性
 */
public class ABWinMaxScore {

    public static int winMostScore(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));//返回AB两个玩家中的最大者
    }

    //先拿者
    //在理性的情况下，肯定拿的是两边中最大的一个
    private static int f(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }

        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
    }

    //后拿者
    //后拿着，在A拿了之后，拿的肯定是A留下中较小的那个
    private static int s(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }

        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));//
    }
}
