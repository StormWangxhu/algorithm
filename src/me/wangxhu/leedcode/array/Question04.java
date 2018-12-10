package me.wangxhu.leedcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>Created on 18-12-10</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 */
public class Question04 {

    static class Solution {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length)
                return findMedianSortedArrays(nums2, nums1); //ensure always nums1 is the shortest array
            int T = nums1.length + nums2.length, low = -1, high = -1;
            int median = (T - 1) / 2;
            boolean isOdd = false;
            if ((T % 2) != 0)
                isOdd = true;

            int s = 0, e = nums1.length - 1;
            while (s <= e) {
                int m = s + (e - s) / 2;
                if ((median - m - 1) < 0 || nums1[m] >= nums2[median - m - 1]) {
                    e = m - 1;
                    low = m;
                    high = median - m;
                } else s = m + 1;
            }

            if (low == -1) {
                if (isOdd) return nums2[median - nums1.length];
                else return (double) (nums2[median - nums1.length] + nums2[median - nums1.length + 1]) / 2.0D;
            } else {
                if (isOdd) return nums1[low] < nums2[high] ? nums1[low] : nums2[high];
                else {
                    //Always sorts maximum of 4 elements hence works in O(1)
                    List<Integer> list = new ArrayList<>();
                    list.add(nums1[low]);
                    if (low + 1 < nums1.length)
                        list.add(nums1[low + 1]);
                    list.add(nums2[high]);
                    if (high + 1 < nums2.length)
                        list.add(nums2[high + 1]);
                    Collections.sort(list);
                    return (double) (list.get(0) + list.get(1)) / 2.0;
                }
            }
        }
    }
}
