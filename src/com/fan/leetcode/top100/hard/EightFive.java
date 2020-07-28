package com.fan.leetcode.top100.hard;

/**
 * @author : PF_23
 * @Description : 最大矩阵
 * @date : 2020/07/27.
 */

public class EightFive {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = (j == 0 ? 1 : dp[i][j - 1]) + 1;
                    int width = dp[i][j];
                    for (int k = i; k >= 0; k--) {
                        width = Math.min(width, dp[k][j]);
                        maxArea = Math.max(maxArea, width * i - k + 1);
                    }
                }
            }
        }
        return maxArea;
    }
}

