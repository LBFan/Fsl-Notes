package com.fan.focusoffer2;

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2022/5/25 22:45.
 */

public class Num95 {

    public static int maxLen(String a, String b) {
        if (a.length() == 0 || b.length() == 0) {
            return 0;
        }

        int[][] dp = new int[a.length()][b.length()];
        dp[0][0] = a.charAt(0) == b.charAt(0) ? 1 : 0;
        dp[0][1] = (a.charAt(0) == b.charAt(0) || a.charAt(0) == b.charAt(1)) ? 1 : 0;
        dp[1][0] = (a.charAt(0) == b.charAt(0) || a.charAt(1) == b.charAt(0)) ? 1 : 0;

        for (int i = 1; i < a.length(); i++) {
            for (int j = 1; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = dp[i  -1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[a.length() - 1][b.length() - 1];
    }

    public static void main(String[] args) {
        String a = "abcde";
        String b = "badfe";
        int maxLen = maxLen(a, b);
        System.out.println(maxLen);
    }
}

