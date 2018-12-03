package me.wangxhu.nowcoder.dp;

/**
 * <p>Created on 18-12-3</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * 斐波那契数列
 * 1 1 2 3 5 8 13
 */
public class Fibonacci {

    static class Solution {

        public int Fibonacci(int n) {

            if (n < 0) {
                return 0;
            }
            if (n == 1 || n == 2) {
                return 1;
            }
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }
}
