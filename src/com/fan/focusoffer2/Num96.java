package com.fan.focusoffer2;

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2022/5/26 23:11.
 */

public class Num96 {

    //使用两行数组村结果
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[2][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < s2.length(); i++) {
            dp[0][i + 1] = s2.charAt(i) == s3.charAt(i) && dp[0][i];
        }

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);
                char ch3 = s3.charAt(i + j + 1);

                dp[(i + 1) % 2][j + 1] = (ch1 == ch3 && dp[i % 2][j + 1]) || (ch2 == ch3 && dp[(i + 1) % 2][j]);
            }
        }

        return dp[s1.length() % 2][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        boolean interleave = isInterleave(s1, s2, s3);
        System.out.println(interleave);
    }
}

