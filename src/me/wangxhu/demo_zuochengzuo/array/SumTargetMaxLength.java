package me.wangxhu.demo_zuochengzuo.array;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-22 10:46
 * @Email: StormWangxhu@163.com
 * @Description: 未排序正数数组中累加和为给定值的最长子数组长度
 * 思路：双指针，窗口思想
 * 当窗口中值=k时，left向右滑，并且更新len,sum-arr[left]
 * 当窗口值>k时，left向右滑，sum-arr[left]
 * 当窗口值<k时，right向右滑，注意是否越界
 *
 * 时间复杂度：O（N）
 * 空间复杂度：O（1）
 */
public class SumTargetMaxLength {

    public int getMaxLength(int[] arr, int k) {

        if (arr == null || arr.length == 0 || k <= 0) {
            return 0;
        }

        int left = 0;//左指针
        int right = 0;//右指针
        int len = 0;//最长=k时的长度
        int sum = arr[0];//窗口中的子数组长度和

        while (right < arr.length) {
            if (sum == k) {
                len = Math.max(len, right - left + 1);
                sum -= arr[left++];
            } else if (sum > k) {
                sum -= arr[left++];
            } else {
                right++;
                if (right == arr.length) {
                    break;
                }
                sum += arr[right];
            }
        }
        return len;
    }
}
