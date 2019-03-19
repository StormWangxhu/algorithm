package me.wangxhu.nowcoder.array;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-18 22:14
 * @Email: StormWangxhu@163.com
 * @Description: 构建乘积数组
 */
public class MultiplyArray {

    public int[] multiply(int[] A) {

        if (A == null || A.length == 1) {
            return null;
        }

        int[] C = new int[A.length];
        C[0] = 1;
        for (int i = 1; i < A.length; i++) {
            C[i] = C[i - 1] * A[i - 1];
        }

        int temp = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            temp = temp * A[i + 1];
            C[i] = C[i] * temp;
        }

        return C;
    }
}
