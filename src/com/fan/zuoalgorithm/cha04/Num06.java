package com.fan.zuoalgorithm.cha04;

/**
 * @author :  PF_23
 * @Description : 打气球的最大分数
 * @date : 2020/03/21.
 */

public class Num06 {
    public int maxCoins1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int n = arr.length;
        int[] help = new int[n + 2];
        help[0] = 1;
        help[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            help[i + 1] = arr[i];
        }
        return process(help, 1, n);
    }

    private int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L - 1] * arr[L] * arr[R + 1];
        }
        // 最后打爆arr[L]的方案和最后打爆arr[R]的方案，先比较一下
        int max = Math.max(arr[L - 1] * arr[L] * arr[R + 1] + process(arr, L + 1, R),
                arr[L - 1] * arr[R] * arr[R + 1] + process(arr, L, R - 1));
        // 尝试中间位置最后打爆的方案
        for (int i = L + 1; i < R; i++) {
            max =
                    Math.max(arr[L - 1] * arr[i] * arr[R + 1] + process(arr, L, i - 1) + process(arr, i + 1, R), max);
        }
        return max;
    }

    /**
     * 动态规划
     *
     * @param arr
     * @return
     */
    public int maxCoins2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int n = arr.length;
        int[] help = new int[n + 2];
        help[0] = 1;
        help[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            help[i + 1] = arr[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = help[i - 1] * help[i] * help[i + 1];
            System.out.println(dp[i][i]);
        }
        for (int L = n; L >= 1; L--) {
            for (int R = L + 1; R <= n; R++) {
                int finalL = help[L - 1] * help[L] * help[R + 1] + dp[L + 1][R];
                int finalR = help[L - 1] * help[R] * help[R + 1] + dp[L][R - 1];
                dp[L][R] = Math.max(finalL, finalR);
                // 中间位置的情况
                for (int i = L + 1; i < R; i++) {
                    dp[L][R] = Math.max(dp[L][R],
                            help[L - 1] * help[i] * help[R + 1] + dp[L][i - 1] + dp[i + 1][R]);
                }
            }
        }
        return dp[1][n];

    }
}

