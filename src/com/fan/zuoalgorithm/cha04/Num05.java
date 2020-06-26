package com.fan.zuoalgorithm.cha04;

/**
 * @author :  PF_23
 * @Description : 换钱的方法数
 * @date : 2020/03/21.
 */

public class Num05 {
    /**
     * 暴力
     *
     * @param arr
     * @param aim
     * @return
     */
    public int coins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    private int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; i * arr[index] <= aim; i++) {
                res += process1(arr, index + 1, aim - i * arr[index]);
            }
        }
        return res;
    }

    /**
     * 记忆搜索法
     *
     * @param arr
     * @param aim
     * @return
     */
    public int coins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] map = new int[arr.length + 1][aim + 1];
        return process2(arr, 0, aim, map);
    }

    private int process2(int[] arr, int index, int aim, int[][] map) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            int mapValue;
            for (int i = 0; i * arr[index] <= aim; i++) {
                mapValue = map[index = 1][aim - i * arr[index]];
                if (mapValue != 0) {
                    res += mapValue == -1 ? 0 : mapValue;
                } else {
                    res += process2(arr, index + 1, aim - i * arr[index], map);
                }
            }
        }
        map[index][aim] = res == 0 ? -1 : res;
        return res;
    }


    /**
     * 动态规划套路法 与上一题套路一样，画表格，结果为找出的位置的值
     *
     * @param arr
     * @param aim
     * @return
     */
    public int coins3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        // 第一列
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        // 第一行
        for (int i = 0; i * arr[0] <= aim; i++) {
            dp[0][i * arr[0]] = 1;
        }
        int num = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                num = 0;
                for (int k = 0; j - arr[i] * k >= 0; k++) {
                    num += dp[i - 1][j - arr[i] * k];
                }
                dp[i][j] = num;
            }
        }
        return dp[arr.length - 1][aim];
    }


    /**
     * 优化空间的动态规划法
     *
     * @param arr
     * @param aim
     * @return
     */
    public int coins4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        // 第一列
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        // 第一行
        for (int i = 0; i * arr[0] <= aim; i++) {
            dp[0][arr[0] * i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[arr.length - 1][aim];
    }

    /**
     * 优化的动态规划 + 空间压缩法 （最优解）
     *
     * @param arr
     * @param aim
     * @return
     */
    public int coins5(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[] dp = new int[aim + 1];
        // 第一行
        for (int i = 0; i * arr[0] <= aim; i++) {
            dp[arr[0] * i] = 1;
        }
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[j] += j - arr[i] >= 0 ? dp[j - arr[i]] : 0;
            }
        }
        return dp[aim];
    }
}

