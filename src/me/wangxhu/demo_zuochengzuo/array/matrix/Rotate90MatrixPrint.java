package me.wangxhu.demo_zuochengzuo.array.matrix;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-03 21:06
 * @Email: StormWangxhu@163.com
 * @Description: 正方形矩阵90度翻转
 */
public class Rotate90MatrixPrint {

    public static void rotate(int[][] matrix) {

        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);//每一次循环为矩阵的一圈，即最外圈，倒数第二圈，即这个循环是控制圈的
        }
    }

    private static void rotateEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        int groups = dC - tC; //即每一圈需要调整几组点（一组调整4个N个点），假如是N * N矩阵，则需要调整（N-1）组。
        int tmp = 0;
        for (int i = 0; i != groups; i++) {
            tmp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[dR - i][tC];
            matrix[dR - i][tC] = matrix[dR][dC - i];
            matrix[dR][dC - i] = matrix[tR + i][dC];
            matrix[tR + i][dC] = tmp;
        }

    }
}
