package me.wangxhu.leedcode.array;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-21 11:22
 * @Email: StormWangxhu@163.com
 * @Description: 预测赢家
 * 给定一个表示分数的非负整数数组。
 * 玩家1从数组任意一端拿取一个分数，随后玩家2继续从剩余数组任意一端拿取分数，然后玩家1拿，……。
 * 每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 */
public class Question486 {

    public boolean PredictTheWinner(int[] nums) {

//        if (nums == null || nums.length == 0) {
//            return false;
//        }
//
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//        }
//        int fValue = f(nums, 0, nums.length - 1);
//        return fValue == Math.max(fValue, sum - fValue);
//    }
//
//    private int f(int[] nums, int i, int j) {
//
//        if (i == j) {
//            return nums[i];
//        }
//        return Math.max(nums[i] + f(nums, i + 1, j), nums[j] + f(nums, i, j - 1));
//    }


        if (nums == null || nums.length == 0) {
            return false;
        }
        int value = f(nums, 0, nums.length - 1);
        return value == Math.max(value, s(nums, 0, nums.length - 1));//返回AB两个玩家中的最大者
    }

    //先拿者
    //在理性的情况下，肯定拿的是两边中最大的一个
    private static int f(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }

        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
    }

    //后拿者
    //后拿着，在A拿了之后，拿的肯定是A留下中较小的那个
    private static int s(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }

        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }
}
