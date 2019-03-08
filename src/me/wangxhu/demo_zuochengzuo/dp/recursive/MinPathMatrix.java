package me.wangxhu.demo_zuochengzuo.dp.recursive;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-08 20:40
 * @Email: StormWangxhu@163.com
 * @Description: 矩阵最小的路径和
 */
public class MinPathMatrix {

    /**
     * 暴力枚举
     *
     * @param matrix
     * @param i
     * @param j
     * @return
     */
    public static int minPath(int[][] matrix, int i, int j) {

        //右下角
        if (i == matrix.length && j == matrix[0].length) {
            return matrix[i][j];
        }

        //最后一行，只能向右
        if (i == matrix.length - 1) {
            return matrix[i][j] + minPath(matrix, i, j + 1);
        }

        //最后一列，只能往下走
        if (j == matrix[0].length - 1) {
            return matrix[i][j] + minPath(matrix, i + 1, j);
        }

        //普遍情况
        int right = minPath(matrix, i, j + 1);//当前(i,j)右边位置到右下角的最小和。加上我自己的值，就是全部代价
        int down = minPath(matrix, i + 1, j);//当前(i,j)下边位置到右下角的和。加上我自己的值，就是全部代价
        return matrix[i][j] + Math.min(right, down);//两种可能性中选择最小的
    }
}
