package me.wangxhu.demo_zuochengzuo.array.matrix;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-04 10:00
 * @Email: StormWangxhu@163.com
 * @Description: 在行和列都排好序的矩阵中找数
 */
public class TargetIsContainsInMartix {

    public static boolean isContaions(int[][] matrix, int target) {

        //从右上角开始
        int tR = 0;
        int tC = matrix[0].length - 1;
        while (tR <= matrix.length - 1 && tC > -1) {
            if (matrix[tR][tC] == target) {
                return true;
            } else if (matrix[tR][tC] > target) {
                tC--;
            } else {
                tR++;
            }
        }
        return false;
    }
}
