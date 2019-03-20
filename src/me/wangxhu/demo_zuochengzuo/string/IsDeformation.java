package me.wangxhu.demo_zuochengzuo.string;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-20 20:25
 * @Email: StormWangxhu@163.com
 * @Description: 判断两个字符串是否互为形变
 *
 *
 * 解决思路：
 * 构造一个map
 */
public class IsDeformation {


    public boolean isDeformation(String str1, String str2) {

        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            map[chars1[i]]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            if (map[chars2[i]]-- < 0) {
                return false;
            }
        }
        return true;

    }
}
