package me.wangxhu.demo_zuochengzuo.dp.recursive;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-07 21:17
 * @Email: StormWangxhu@163.com
 * @Description: 递归求n的阶乘
 */
public class Factorial {

    /**
     * 最基本的求法
     *
     * @param n
     * @return
     */
    public static long getFactorial1(long n) {

        long result = 1L;
        for (long i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * 使用递归的方式
     *
     * @param n
     * @return
     */
    public static long getFactorial2(long n) {

        if (n <= 2) {
            return n;
        }
        return (long) n * getFactorial2(n - 1);
    }
}
