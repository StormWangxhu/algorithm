package me.wangxhu.nowcoder.array;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-01 16:51
 * @Email: StormWangxhu@163.com
 * @Description: 求解旋转数组中的最小数字
 */
public class MinNumberInRotateArray {

    /**
     * O(n)时间复杂度
     * 335ms
     */
    static class Solution1 {

        public int minNumberInRotateArray(int[] array) {

            if (array == null || array.length == 0) {
                return 0;
            }

            int result = array[0];//最小值变量，不断比较并更新
            for (int i = 0; i < array.length; i++) {
                if (result > array[i + 1]) { //[3,4,5,1,2]，即当5>1 时，将1赋值给最小变量，结束循环并返回。
                    result = array[i + 1];
                    break;
                }
            }
            return result;
        }
    }


    static class Solution2 {

        public int minNumberInRotateArray(int[] array) {

            if (array == null || array.length == 0) {
                return 0;
            }

            int left = 0, right = array.length - 1;
            int mid = left + (right - left) / 2;
            while (left < right) {
                if (array[mid] < array[right]) {
                    right = mid;
                } else {
                    left = mid+1;
                }
            }
            return array[left];
        }
    }
}
