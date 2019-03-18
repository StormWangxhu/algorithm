package me.wangxhu.nowcoder.array;

import java.util.*;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-18 15:55
 * @Email: StormWangxhu@163.com
 * @Description: 数组中只出现一次的数字
 */
public class FindNumsAppearOnceII {

    //17ms
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

        if (array == null || array.length < 2) {
            num1[0] = 0;
            num2[0] = 0;
            return;
        }

        Arrays.sort(array);
        Stack<Integer> stack = new Stack<>();
        stack.push(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (!stack.isEmpty()) {
                if (stack.peek() == array[i]) {
                    stack.pop();
                } else {
                    stack.push(array[i]);
                }
            } else {
                stack.push(array[i]);
            }
        }
        num1[0] = stack.pop();
        num2[0] = stack.pop();

    }
}
