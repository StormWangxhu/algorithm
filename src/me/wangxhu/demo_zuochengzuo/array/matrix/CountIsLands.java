package me.wangxhu.demo_zuochengzuo.array.matrix;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-06 20:53
 * @Email: StormWangxhu@163.com
 * @Description: 岛问题
 * 牛逼
 * 一个矩阵中只有0和1这两种值，每个位置都可以和自己的上，下，左，右四个位置相连，
 * 如果有一片1连在一起，这个部分叫做一个岛，求一个矩阵中有多少个岛？
 *
 * 并查集也可以做
 */
public class CountIsLands {

    public static int countIsLands(int[][] matrix) {

        if (matrix == null || matrix[0] == null) {
            return 0;
        }

        int N = matrix.length;
        int M = matrix[0].length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][i] == 1) {
                    res++;//岛的数量+1
                    infect(matrix, i, j, N, M);//感染函数
                }
            }
        }
        return res;
    }

    /**
     * 感染函数
     *
     * @param matrix 二维矩阵
     * @param i      控制行数
     * @param j      控制列数
     * @param N      二维矩阵最大行数
     * @param M      二维矩阵最大列数
     */
    private static void infect(int[][] matrix, int i, int j, int N, int M) {

        //在越界和当前数不为1的时候就不执行了,直接返回
        //即每个位置为1才会执行，感染为2或者0的位值根本不会进去递归，直接返回了！
        if (i < 0 || i >= N || j < 0 || j >= M || matrix[i][j] != 1) {
            return;
        }

        matrix[i][j] = 2;//将当前位置更改为2

        //然后当前值再去感染他周围的值
        infect(matrix, i + 1, j, N, M); //它的上
        infect(matrix, i - 1, j, N, M);//它的下
        infect(matrix, i, j + 1, N, M);//它的右
        infect(matrix, i, j - 1, N, M);//它的左

    }
}
