package me.wangxhu.demo_zuochengzuo.array.matrix;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-04 09:25
 * @Email: StormWangxhu@163.com
 * @Description: 之字型打印矩阵
 */
public class PrintMatrixZigZag {

    public static void printMatrixZigZag(int[][] matrix) {

        //点(tR,tC)，该点向右移动至最右再往下
        int tR = 0;
        int tC = 0;
        //点(dR,dC)两者都同时在左上角，该点往下移动至最下再往右
        int dR = 0;
        int dC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        //控制打印方向
        boolean fromUp = false;
        while (tR != dR + 1) {
            printLevel(matrix, tR, tC, dR, dC, fromUp);//打印对角函数
            tR = tC == endC ? tR + 1 : tR;
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    /**
     * 打印对角函数
     *
     * @param matrix
     * @param tR
     * @param tC
     * @param dR
     * @param dC
     * @param fromUp
     */
    private static void printLevel(int[][] matrix, int tR, int tC, int dR, int dC, boolean fromUp) {
        if (fromUp) {//右上往左下打印
            while (tR <= dR) {//(tR != dR+1)  此处边界条件，即以行号为边界条件，tR往下移动不能超过最后一行dR
                System.out.print(matrix[tR++][tC--]);
            }
        } else {//左下往右上打印.dR往上移动，不能超过最上面一行tR.
            while (dR != tR - 1) {
                System.out.print(matrix[dR--][dC++]);
            }
        }
    }
}
