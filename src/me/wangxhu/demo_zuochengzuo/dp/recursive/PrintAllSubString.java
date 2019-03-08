package me.wangxhu.demo_zuochengzuo.dp.recursive;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-08 19:19
 * @Email: StormWangxhu@163.com
 * @Description: 打印一个字符串的全部子序列，包括空字符串
 */
public class PrintAllSubString {

    public static void printAllSubString(char[] str, int i, String res) {

        if (i == str.length) {
            System.out.println(res);
            return;
        }

        printAllSubString(str, i + 1, res);//不要那个字符串
        printAllSubString(str, i + 1, res + String.valueOf(str[i]));//要字符串，则和上一个拼接
    }
}
