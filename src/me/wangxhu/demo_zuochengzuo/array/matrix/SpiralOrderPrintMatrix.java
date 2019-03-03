package me.wangxhu.demo_zuochengzuo.array.matrix;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-03 19:57
 * @Email: StormWangxhu@163.com
 * @Description: 转圈打印矩阵
 * 这种处理矩阵的思想
 * 左上角坐标： (tR,tC)
 * 右下角坐标： (dR,dC)
 */
public class SpiralOrderPrintMatrix {

    public void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);//每一次循环为矩阵的一圈，即最外圈，倒数第二圈，即这个循环是控制圈的
        }

    }

    private void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        //只有一行时
        if (tR == dR) {
            for (int i = 0; i <= tC; i++) {
                System.out.print(matrix[tR][i]);
            }
        }

        //只有一列的时候
        if (tC == dC) {
            for (int i = 0; i < dR; i++) {
                System.out.print(matrix[i][tC]);
            }
        }

        //常规操作
        int curC = tC;
        int curR = tR;
        while (curC != dC) {
            System.out.print(matrix[tR][curC++] + " ");
        }

        while (curR != dR) {
            System.out.print(matrix[curR++][dC] + " ");
        }

        while (curC != tC) {
            System.out.print(matrix[curC--][dR] + " ");
        }

        while (curR != tR) {
            System.out.print(matrix[curR--][tC] + " ");
        }
    }
}
