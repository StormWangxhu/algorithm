package me.wangxhu.nowcoder.array;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-15 21:19
 * @Email: StormWangxhu@163.com
 * @Description: 在目标二维数组中寻找目标数
 * 从左下角到右上角去寻找
 */
public class FindTargetNumInMatrixII {

    public boolean Find(int target, int[][] array) {

        int R = array.length;
        int C = array[0].length;
        int row = R - 1;
        int col = 0;
        while (col <= C - 1 && row >= 0) {
            if (array[row][col] == target) {
                return true;
            } else if (array[row][col] < target) {
                col++;
            } else {
                row--;
            }
        }
        return false;
    }
}
