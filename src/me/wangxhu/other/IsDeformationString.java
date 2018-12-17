package me.wangxhu.other;

/**
 * <p>Created on 18-12-17</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * 相似字符串满足： 字符种类一样，每个字符出现的次数一样
 * 判断两个字符串是否是相似字符串
 */
public class IsDeformationString {

    public boolean isDeformation(String str1, String str2) {

        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }

        char[] chr1 = str1.toCharArray();
        char[] cha2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            map[chr1[i]]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            if (map[cha2[i]]-- < 0) {
                return false;
            }
        }

        return true;
    }
}
