package me.wangxhu.demo_zuochengzuo.dp;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-21 22:28
 * @Email: StormWangxhu@163.com
 * @Description: 最长有效括号子串
 * 动态规划：
 * 若以'('结尾的，肯定不是有效括号，dp[i]=0;
 * 所以只看当前结尾的是'('。
 */
public class IsStringMaxLength {

    public int maxLength(String str) {

        if (str == null || str.equals("")) {
            return 0;
        }

        char[] chars = str.toCharArray();
        int[] dp = new int[chars.length];
        int pre = 0;//dp[0] = 0，第一个字符不管是什么，都肯定不是有效的，所以循环从1开始
        int res = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chars[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);//pre>0保证前面还有并且合法，若pre前一个存在的话，dp[pre-1]肯定不为0，
                    //若没有有效括号的话，dp[pre-1]值为0
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
