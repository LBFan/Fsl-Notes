package com.fan.zuoalgorithm.cha04;

/**
 * @author :  PF_23
 * @Description : 字符串的交错组成
 * @date : 2020/03/21.
 */

public class Num14 {
    /**
     * 金典动态规划
     *
     * @param str1
     * @param str2
     * @param aim
     * @return
     */
    public boolean isCross1(String str1, String str2, String aim) {
        if (str1 == null || str2 == null || aim == null) {
            return false;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        char[] chaim = aim.toCharArray();
        // 如果长度和不等于chaim的长度
        if (chs1.length + chs2.length != chaim.length) {
            return false;
        }
        boolean[][] dp = new boolean[chs1.length + 1][chs2.length + 1];
        // 初始化第一列
        for (int i = 0; i < chs1.length; i++) {
            // 如果aim[0..i - 1] == str1[0..i - 1]
            if (chaim[i - 1] != chs1[i - 1]) {
                break;
            }
            dp[i][0] = true;
        }
        // 初始化第一行
        for (int i = 0; i < chs2.length; i++) {
            // 如果aim[0..i - 1] == str2[0..i - 1]
            if (chaim[i - 1] != chs2[i - 1]) {
                break;
            }
            dp[0][i] = true;
        }
        for (int i = 1; i <= chs1.length; i++) {
            for (int j = 1; j < chs2.length; j++) {
                if (dp[i - 1][j] && (chs1[i - 1] == chaim[i + j - 1])) {
                    dp[i][j] = true;
                } else if (dp[i][j - 1] && (chs2[j - 1] == chaim[i + j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[chs1.length][chs2.length];
    }


    /**
     * 空间压缩 + 动态规划
     *
     * @param str1
     * @param str2
     * @param aim
     * @return
     */
    public boolean isCross2(String str1, String str2, String aim) {
        if (str1 == null || str2 == null || aim == null) {
            return false;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        char[] chaim = aim.toCharArray();
        // 如果长度和不等于chaim的长度
        if (chs1.length + chs2.length != chaim.length) {
            return false;
        }
        char[] longs = chs1.length >= chs2.length ? chs1 : chs2;
        char[] shorts = chs1.length < chs2.length ? chs1 : chs2;
        boolean[] dp = new boolean[shorts.length + 1];
        dp[0] = true;
        for (int i = 1; i <= shorts.length; i++) {
            dp[0] = dp[0] && longs[i - 1] == chaim[i - 1];
            for (int j = 1; j <= longs.length; j++) {
                if ((longs[i - 1] == chaim[j + i - 1]) && dp[j]) {
                    dp[j] = true;
                } else if ((shorts[j - 1] == chaim[i + j - 1] && dp[j - 1])) {
                    dp[j] = true;
                } else {
                    dp[j] = false;
                }
            }
        }
        return dp[shorts.length];
    }
}

