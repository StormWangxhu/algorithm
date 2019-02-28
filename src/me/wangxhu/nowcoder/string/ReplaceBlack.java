package me.wangxhu.nowcoder.string;

import sun.jvm.hotspot.debugger.posix.elf.ELFException;

/**
 * @Author: StormWangxhu
 * @Time: 2019-02-28 22:00
 * @Email: StormWangxhu@163.com
 * @Description: 替换空格
 */
public class ReplaceBlack {

    public static class Solution1 {

        public String replaceSpace(StringBuffer str) {
            for (int i = 0; i < str.length(); i++) {
                char char1 = str.charAt(i);
                if (char1 == ' ') {
                    str.replace(i, i + 1, "%20");
                }
            }
            return str.toString();
        }

    }


    /**
     *
     * 时间复杂度O（N）
     */
    public static class Solution2 {

        public String replaceSpace(StringBuffer str) {

            //计算出空格的数量
            int spaceCount = 0, oldLength = str.length();
            for (int i = 0; i < oldLength; i++) {
                if (str.charAt(i) == ' ') {
                    spaceCount++;
                }
            }

            //计算出空格替换后，字符的新长度
            int newLength = oldLength + 2 * spaceCount;
            //两个指针，P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置
            int P1 = oldLength - 1, P2 = newLength - 1;
            //扩大缓冲区大小
            str.setLength(newLength);
            while (P1 >= 0 && P2 > P1) {
                if (str.charAt(P1) == ' ') {
                    str.setCharAt(P2--, '0');
                    str.setCharAt(P2--, '2');
                    str.setCharAt(P2--, '%');
                }else {
                    str.setCharAt(P2--,str.charAt(P1));
                }
                P1--;
            }

            return str.toString();

        }
    }
}
