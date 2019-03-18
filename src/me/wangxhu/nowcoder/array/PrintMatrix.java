package me.wangxhu.nowcoder.array;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-18 16:23
 * @Email: StormWangxhu@163.com
 * @Description: 顺时针打印矩阵  26ms
 */
public class PrintMatrix {

    public ArrayList<Integer> printMatrix(int[][] matrix) {

        if (matrix == null) {
            return null;
        }

        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        int tR = 0;
        int tC = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--, list);
        }
        return list;
    }

    private void printEdge(int[][] matrix, int tR, int tC, int dR, int dC, ArrayList<Integer> list) {

        //子矩阵只有一列时
        if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                list.add(matrix[i][tC]);
            }
        } else if (tR == dR) {//子矩阵只有一行时
            for (int i = tC; i <= dC; i++) {
                list.add(matrix[tR][i]);
            }
        } else {

            int curR = tR;
            int curC = tC;
            while (curC != dC) {
                list.add(matrix[curR][curC++]);
            }

            while (curR != dR) {
                list.add(matrix[curR++][curC]);
            }

            while (curC != tC) {
                list.add(matrix[curR][curC--]);
            }

            while (curR != tR) {
                list.add(matrix[curR--][curC]);
            }
        }
    }
}
