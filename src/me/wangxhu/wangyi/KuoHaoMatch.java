package me.wangxhu.wangyi;

import java.util.Stack;

/**
 * <p>Created on 18-12-16</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * 括号匹配问题 :
 * {}[]()  true;
 * {] (}    false;
 */
public class KuoHaoMatch {

    static class Solution {

        public boolean isValid(String expression) {

            char[] chars = expression.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < chars.length; i++) {
                //遇到左括号压栈，其他字符忽略
                if (chars[i] == '{' || chars[i] == '[' || chars[i] == '(') {
                    stack.push(chars[i]);
                }

                if (chars[i] == '}' || chars[i] == ']' || chars[i] == ')') {
                    //我要匹配的括号
                    char match = chars[i] == '}' ? '{' : (chars[i] == ']' ? '[' : '(');
                    if (stack.isEmpty() || stack.pop().equals(match)) {
                        return false;
                    }
                }
            }

            //栈里面的东西要全部配完
            return stack.isEmpty();
        }
    }

}
