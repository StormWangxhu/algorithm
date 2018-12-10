package me.wangxhu.leedcode.array;

/**
 * <p>Created on 18-12-10</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode74. 搜索二维矩阵
 * <p>
 * 在一个二维矩阵中寻找目标值,存在返回true,不存在返回false
 */
public class Question74 {

    static class Solution {

        public boolean searchMatrix(int[][] matrix, int target) {

            if (matrix.length == 0)
                return false;
            int row = 0, col = matrix[0].length - 1;

            while (row < matrix.length && col >= 0) {
                if (matrix[row][col] == target)
                    return true;
                if (matrix[row][col] < target)
                    row++;
                else
                    col--;
            }
            return false;
        }
    }


    static class Solution1 {

        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0) return false;
            int M = matrix.length;
            int N = matrix[0].length;
            int r = 0, c = N - 1;
            while (r < M && c >= 0) {
                if (matrix[r][c] == target) return true;
                else if (target < matrix[r][c]) --c;
                else if (target > matrix[r][c]) r++;
            }
            return false;
        }
    }

}
