package me.wangxhu.demo_zuochengzuo.dp.recursive;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-07 21:47
 * @Email: StormWangxhu@163.com
 * @Description: 递归求解汉诺塔问题
 * 三步骤：
 * 解题思路：
 * 1. 1~n-1 from---help
 * 2. n     from---to
 * 3.1~n-1  help---to
 */
public class Hannota {

    /**
     * @param N    1--N个盘
     * @param from 源杆
     * @param to   目标杆
     * @param help 辅助杆
     */
    public static void hannota(int N, String from, String to, String help) {

        if (N == 1) {
            System.out.println("Move 1 from " + from + " to " + to);
        } else {
            hannota(N - 1, from, help, to);//对1到n-1，是将其从from移动到help上
            System.out.println("Move " + N + " from " + from + " to " + to);
            hannota(N - 1, help, to, from);//将1--n-1再从help上移动到to上.
        }
    }
}
