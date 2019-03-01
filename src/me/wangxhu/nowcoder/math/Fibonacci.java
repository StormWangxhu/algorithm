package me.wangxhu.nowcoder.math;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-01 09:27
 * @Email: StormWangxhu@163.com
 * @Description: 斐波那契数列
 * f(0)=0,f(1)=1.
 * f(n)=f(n-1)+f(n-2)  n>=2
 */
public class Fibonacci {

    /**
     * 使用递归来求解,975ms
     */
    static class Solution1 {

        public int Fibonacci(int n) {

            if (n < 2) {
                return n;
            }
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }

    /**
     * 使用动态规划，将解缓存起来,19ms
     * 会看到，比起递归求解，动态规划
     */
    static class Solution2 {

        public int Fibonacci(int n) {

            if (n < 2) {
                return n;
            }
            int[] sums = new int[n + 1];
            sums[0] = 0;
            sums[1] = 1;
            for (int i = 2; i <= n; i++) {
                sums[i] = sums[i - 1] + sums[i - 2];
            }
            return sums[n];
        }
    }

    /**
     * 动态规划求解，因为n>=2时，第i个数只与第i-1和i-2有关
     * 20ms
     */
    static class Solution3 {

        public int Fibonacci(int n) {

            if (n < 2) {
                return n;
            }

            int pre1 = 0, pre2 = 1;
            int fib = 0;
            for (int i = 2; i <= n; i++) {
                fib = pre1 + pre2;
                pre1 = pre2;
                pre2 = fib;
            }
            return fib;
        }
    }


    /**
     * 因为题目要求：待求解的n<=40,所以可以将待前40项都先计算，之后就能以O（1）时间复杂度计算出来
     * 13ms
     */
    static class Solution4 {

        private int[] fib = new int[40];

        public Solution4(){
            fib[1]=1;
            fib[2]=2;
            for (int i = 2; i <fib.length ; i++) {
                fib[i]=fib[i-1]+fib[i-2];
            }
        }

        public int Fibonacci(int n){
            return fib[n];
        }
    }
}
