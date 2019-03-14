package me.wangxhu.demo_zuochengzuo.linkedlist;

import java.util.LinkedList;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-11 20:58
 * @Email: StormWangxhu@163.com
 * @Description: 生成窗口最大值数组
 */


/**
 * 滑动窗口的最大值
 * 牛客网
 *
 * 21ms
 */
public class GetMaxWindow {


    public int[] getMaxWindow(int[] nums, int k) {

        if (nums == null || k < 1 || nums.length < k) {
            return new int[]{};//return null 在Leetcode上最后一个实例过不去
        }

        LinkedList<Integer> pmax = new LinkedList();//双端队列
        int[] res = new int[nums.length - k + 1];//结果数组
        int index = 0;//结果数组中下标

        for (int i = 0; i < nums.length; i++) {
            while (!pmax.isEmpty() && nums[pmax.peekLast()] <= nums[i]) {
                pmax.pollLast();
            }
            pmax.addLast(i);

            if (pmax.peekFirst() == i - k) {
                pmax.pollFirst();
            }
            if (i >= k - 1) {
                res[index++] = nums[pmax.peekFirst()];
            }
        }
        return res;
    }
}
