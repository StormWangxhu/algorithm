package me.wangxhu.nowcoder.array;

import java.util.ArrayList;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-18 15:30
 * @Email: StormWangxhu@163.com
 * @Description: 数组中只出现一次的数字
 */
public class FindNumsAppearOnce {

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

        if (array == null || array.length < 2) {
            return;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (!list.contains(array[i])) {
                list.add(array[i]);
            } else {
                list.remove(new Integer(array[i]));
            }
        }
        if (list.size() > 1) {
            num1[0] = list.get(0);
            num2[0] = list.get(1);
        }
    }
}
