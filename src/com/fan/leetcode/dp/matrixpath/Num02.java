package com.fan.leetcode.dp.matrixpath;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 矩阵的总路径数
 * 题目描述：统计从矩阵左上角到右下角的路径总数，每次只能向右或者向下移动。
 * @date : 2020/01/06.
 */

public class Num02 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    /**
     * 也可以直接用数学公式求解，这是一个组合问题。
     * 机器人总共移动的次数 S=m+n-2，向下移动的次数 D=m-1，那么问题可以看成从 S 中取出 D 个位置的组合数量，这个问题的解为 C(S, D)。
     */
    public int uniquePathsByMath(int m, int n) {
        // 总共移动的次数
        int s = m + n - 2;
        // 向下移动的次数
        int d = m - 1;
        long ret = 1;
        for (int i = 1; i <= d; i++) {
            ret = ret * (s - d + i) / i;
        }
        return (int) ret;
    }
}

