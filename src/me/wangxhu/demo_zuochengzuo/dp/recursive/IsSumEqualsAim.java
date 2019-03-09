package me.wangxhu.demo_zuochengzuo.dp.recursive;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-08 21:22
 * @Email: StormWangxhu@163.com
 * @Description: 给定一个数组arr（arr全是正数），和一个整数aim（也是正数）。
 * 如果可以任意选择arr中的数字，能不能累加得到aim，返回true或者false。
 */
public class IsSumEqualsAim {

    /**
     * @param arr
     * @param i   i位置
     * @param sum i位置的和
     * @param aim
     * @return
     */
    public static boolean isSumEqualsAim(int[] arr, int i, int sum, int aim) {

        /**
         * 所有的情况结果都集中在叶子节点上
         */
        if (i == arr.length) {
            return sum == aim;
        }

        return isSumEqualsAim(arr, i + 1, sum, aim) || isSumEqualsAim(arr, i + 1, sum + arr[i], aim);
    }
}
