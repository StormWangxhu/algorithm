package me.wangxhu.leedcode.array;

/**
 * <p>Created on 18-12-18</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode704 二分查找
 */
public class Question704 {

    /**
     * 二分查找模板1
     */
    static class Solution {

        public int search(int[] nums, int target) {

            if (nums == null || nums.length == 0) {
                return -1;
            }

            int low = 0;
            int heigh = nums.length - 1;

            while (low <= heigh) {
                int mid = (low + (heigh - low) / 2);
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    heigh = mid - 1;
                }
            }
            return -1;
        }
    }
}
