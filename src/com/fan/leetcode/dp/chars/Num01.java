package com.fan.leetcode.dp.chars;

/**
 * @author :  PF_23
 * @Description : 删除两个字符串的字符使它们相等
 * <p>
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * <p>
 * 可以转换为求两个字符串的最长公共子序列问题。
 * 求出最长公共序列的长度，然后分别删除序列长度- 公共长度。即：m + n - 2 * dp[m][n].
 * @date : 2020/01/14.
 */

public class Num01 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // 表示两个字符串的公共长度 dp[i][j]：表示word1前i个字符中和word2前j个字符中相同字符的个数
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }
}

