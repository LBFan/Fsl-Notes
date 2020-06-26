package com.fan.zuoalgorithm.cha04;

/**
 * @author :  PF_23
 * @Description : 龙与地下城游戏问题
 * @date : 2020/03/21.
 */

public class Num15 {
    /**
     * 动态规划常规
     *
     * @param m
     * @return
     */
    public int minHP1(int[][] m) {
        // dp[i][j] 表示如果骑士要走上位置（i，j），并且从该位置选一条最优的路径，最后走到右下角，骑士起码应该具备的血量。
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 1;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row--][col--];
        // 见到公主的最低血量要求
        dp[row][col] = m[row][col] > 0 ? 1 : -m[row][col] + 1;
        // 初始化最后一行的血量
        for (int i = col - 1; i >= 0; i--) {
            dp[row][i] = Math.max(dp[row][i + 1] - m[row][i], 1);
        }
        int right;
        int down;
        for (int i = row - 1; i >= 0; i--) {
            dp[i][col] = Math.max(dp[i + 1][col] - m[i][col], 1);
            for (int j = col - 1; j >= 0; j--) {
                right = Math.max(dp[i][j + 1] - m[i][j], 1);
                down = Math.max(dp[i + 1][j] - m[i][j], 1);
                dp[i][j] = Math.min(right, down);
            }
        }
        return dp[0][0];
    }

    /**
     * 空间压缩 + 动态规划
     *
     * @param m
     * @return
     */
    public int minHP2(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 1;
        }

        int more = Math.max(m.length, m[0].length);
        int less = Math.min(m.length, m[0].length);
        boolean rowmore = more == m.length;
        int[] dp = new int[less];
        // 最右下角的值
        int tmp = m[m.length - 1][m[0].length - 1];
        dp[less - 1] = tmp > 0 ? 1 : -tmp + 1;

        int row;
        int col;
        for (int j = less - 2; j >= 0; j--) {
            row = rowmore ? more - 1 : j;
            col = rowmore ? j : more - 1;
            dp[j] = Math.max(dp[j + 1] - m[row][col], 1);
        }
        int choosen1;
        int choosen2;
        for (int i = more - 2; i >= 0; i--) {
            row = rowmore ? i : more - 1;
            col = rowmore ? less - 1 : i;
            dp[less - 1] = Math.max(dp[less - 1] - m[row][col], 1);
            for (int j = less - 2; j >= 0; j--) {
                row = rowmore ? i : j;
                col = rowmore ? j : i;
                choosen1 = Math.max(dp[j] - m[row][col], 1);
                choosen2 = Math.max(dp[j + 1] - m[row][col], 1);
                dp[j] = Math.min(choosen2, choosen1);
            }
        }
        return dp[0];
    }
}

