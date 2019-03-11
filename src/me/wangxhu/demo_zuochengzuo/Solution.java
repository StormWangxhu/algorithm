package me.wangxhu.demo_zuochengzuo;

import java.util.Scanner;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-09 19:38
 * @Email: StormWangxhu@163.com
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        quickSort(a, 0, a.length - 1);
        quickSort(b, 0, b.length - 1);
        int[] dp = new int[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            dp[i] = a[i] * b[i];
            res += dp[i] + dp[i + 1];
        }
        System.out.println(res);
    }

    public static void quickSort(int[] arr, int L, int R) {

        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);//这行就是随机快速排序

        //在L<R条件下进行，不满足直接返回
        if (L < R) {
            int[] p = partition(arr, L, R);//大小为2,返回的是等于区域区间边界坐标
            quickSort(arr, L, p[0] - 1);//将小于区域拿去递归，大于区域也拿起递归
            quickSort(arr, p[1] + 1, R);
        }
    }


    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;//默认以数组最后一个元素为num
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
