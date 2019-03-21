package me.wangxhu.demo_zuochengzuo.string;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-21 09:31
 * @Email: StormWangxhu@163.com
 * @Description: 括号字符串的有效性
 */
public class IsStringValid {

    public boolean isValid(String str) {

        if (str == null || str.equals("")) {
            return false;
        }

        char[] chars = str.toCharArray();
        int status = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '(' && chars[i] != ')') {
                return false;
            }
            if (chars[i] == ')' && --status < 0) {
                return false;
            }
            if (chars[i] == '(') {
                status++;
            }
        }
        return status == 0;
    }

}
