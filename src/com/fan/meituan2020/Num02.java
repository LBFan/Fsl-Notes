package com.fan.meituan2020;

import java.util.Scanner;

/**
 * @Description : 字符串匹配
 * @Author : shulin.fan
 * @Date : 2020/8/19
 */
public class Num02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        boolean isMatch = match(s, p);
        int res = isMatch ? 1 : 0;
        System.out.println(res);
    }

    private static boolean match(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s.charAt(i) == '*';
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || s.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (s.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        //*1456]ww2?6
        //sdfgh1456]ww256
        return dp[m][n];
    }
}
