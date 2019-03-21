package me.wangxhu.demo_zuochengzuo.string;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-21 09:31
 * @Email: StormWangxhu@163.com
 * @Description: 括号字符串的有效性
 * 算法：count值遇到左括号就++,遇到右括号就--。
 * 如果中途没有count为负值的情况，那么当遍历完后，count值为0返回true，不为0，返回false。
 * 因为一个有效的括号组合，左括号和右括号数量是一样多的。
 */
public class IsStringValid {

    public boolean isValid(String str) {

        if (str == null || str.equals("")) {
            return false;
        }

        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '(' && chars[i] != ')') {//中间混进来别的字符
                return false;
            }
            if (chars[i] == ')' && --count < 0) {
                return false;
            }
            if (chars[i] == '(') {
                count++;
            }
        }
        return count == 0;//遍历完之后，判断
    }

}
