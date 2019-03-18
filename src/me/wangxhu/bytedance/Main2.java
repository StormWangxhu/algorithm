package me.wangxhu.bytedance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-16 11:09
 * @Email: StormWangxhu@163.com
 * @Description:
 */
public class Main2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            int length = scanner.nextInt();
            num[i] = length;
        }
        Arrays.sort(num);
        solution2(num, N, M);
    }

    private static int solution2(int[] num, int N, int M) {
       return 0;
    }
}
