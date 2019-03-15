package me.wangxhu.nowcoder.array;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-15 21:07
 * @Email: StormWangxhu@163.com
 * @Description: 在目标二维数组中寻找目标数
 * 在二维数组中的右上角开始寻找，一直向左下角开始
 */
public class FindTargetNumInMatrix {

    public boolean Find(int target, int[][] array) {

        int R = array.length;
        int C = array[0].length;
        int row = 0, col = C - 1;

        while (row < R && col >= 0) {

            if (array[row][col] == target) {
                return true;
            } else if (array[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;

    }
}
