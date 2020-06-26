package com.fan.zuoalgorithm.cha04;

/**
 * @author :  PF_23
 * @Description : 还钱的最少货币数
 * @date : 2020/03/21.
 */

public class Num03 {
    /**
     * 暴力递归
     *
     * @param arr
     * @param aim
     * @return
     */
    public int minCoins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        return process(arr, 0, aim);
    }

    /**
     * 当前考虑的面值是arr[i],还剩rest的钱需要找零
     * 如果返回-1，说明自由使用arr[i .. N- 1]面值的情况下，无论如何也如法找零rest
     * 如果返回不是-1，代表自由使用arr[i .. N- 1]面值的情况下，找零rest需要的最少张数
     *
     * @param arr
     * @param i
     * @param rest
     * @return
     */
    private int process(int[] arr, int i, int rest) {
        if (i == arr.length) {
            return rest == 0 ? 0 : -1;
        }

        // 最少张数，初始值为-1， 因为还没有找到有效解
        int res = -1;

        for (int j = 0; j * arr[i] <= rest; j++) {
            int next = process(arr, i + 1, rest - j * arr[i]);
            if (next != -1) {
                // 说明后续过程有效
                res = res == -1 ? next + j : Math.min(res, next + j);
            }
        }
        return res;
    }

    public int minCoins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int N = arr.length;
        // 表示在还剩N个面值硬币的情况下找零aim的最少数值
        int[][] dp = new int[N + 1][aim + 1];
        // 设置最后一排的值
        for (int col = 1; col <= aim; col++) {
            dp[N][col] = -1;
        }
        // 从低往上计算每一行
        for (int i = N - 1; i >= 0; i--) {
            // 每一行都从左到右
            for (int rest = 0; rest <= aim; rest++) {
                // 初始时先设置dp[i][rest]的值无效
                dp[i][rest] = -1;
                if (dp[i + 1][rest] != -1) {
                    // 下面的值如果有效，先设置成下面的值
                    dp[i][rest] = dp[i + 1][rest];
                }
                // 如果左边的值不越界且有效
                if (rest - arr[i] >= 0 && dp[i][rest - arr[i]] != -1) {
                    // 如果之前下面的值无效
                    if (dp[i][rest] == -1) {
                        // 设置为左边的值
                        dp[i][rest] = dp[i][rest - arr[i]];
                    } else {
                        // 否则，去下面和左边的最小值
                        dp[i][rest] = Math.min(dp[i + 1][rest], dp[i][rest - arr[i]]);
                    }
                }
            }
        }
        return dp[0][aim];
    }
}

