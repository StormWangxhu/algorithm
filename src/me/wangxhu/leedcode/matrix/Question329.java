package me.wangxhu.leedcode.matrix;

/**
 * <p>Created on 18-12-17</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode329：  矩阵中的最长递增路径
 * <p>
 * 难度级别： 难
 */
public class Question329 {

    /**
     * 递归
     */
    static class Solution {

        public int longestIncreasingPath(int[][] matrix) {

            int max = Integer.MIN_VALUE;
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    max = Math.max(max, process(matrix, row, col));
                }
            }
            return max;
        }

        private int process(int[][] matrix, int row, int col) {

            int path = 1;//原地不动的长度
            //左
            if ((col > 0 && matrix[row][col - 1] > matrix[row][col])) {
                path = Math.max(process(matrix, row, col - 1) + 1, path);
            }
            //上
            if ((row > 0 && matrix[row - 1][col] > matrix[row][col])) {
                path = Math.max(process(matrix, row - 1, col) + 1, path);
            }
            //右
            if ((col > matrix[0].length-1 && matrix[row][col] < matrix[row][col + 1])) {
                path = Math.max(process(matrix, row, col + 1) + 1, path);
            }
            //下
            if ((row < matrix.length-1 && matrix[row][col] < matrix[row + 1][col])) {
                path = Math.max(process(matrix, row + 1, col) + 1, path);
            }
            return path;
        }
    }
}
