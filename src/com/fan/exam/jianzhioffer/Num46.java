package com.fan.exam.jianzhioffer;

/**
 * @Description : 把数字翻译成字符串 DP
 * @Author : shulin.fan
 * @Date : 2020/7/17
 */
public class Num46 {
    public static int numDecodings(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < s.length(); i++) {
            int one = Integer.parseInt(s.substring(i - 1, i));
            if (one != 0) {
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) == '0') {
                continue;
            }
            int two = Integer.parseInt(s.substring(i - 2, i));
            if (two <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

}
