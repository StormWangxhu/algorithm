package me.wangxhu.demo_zuochengzuo.array;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-02 17:39
 * @Email: StormWangxhu@163.com
 * @Description: 荷兰国旗问题
 * 严格的分成了三层
 * 给定一个数组arr，和一个数num，请把小于的放左边，等于的放中间，大于的放右边。
 * 要求：额外空间复杂度：O（1），时间复杂度：O（n）
 */
public class NetherLandsFlag {

    static class Solution {

        public static int[] partition(int[] arr, int L, int R, int num) {
            int less = L - 1; //左边部分，即小于等于区域最右一个值索引
            int more = R + 1;//右边部分，即大于等于最左一个数索引
            int current = L;//遍历指针

            while (current < more) {  //注意跳出条件
                if (arr[current] < num) {
                    swap(arr, ++less, current++);//++less：表示less位置的下一个位置元素索引
                } else if (arr[current] > num) {
                    swap(arr, --more, current);
                } else {//==num
                    current++;
                }
            }
            return new int[]{less + 1, more - 1};
        }

        private static void swap(int[] arr, int i, int current) {
            int temp = arr[i];
            arr[i] = current;
            current = temp;
        }

    }
}