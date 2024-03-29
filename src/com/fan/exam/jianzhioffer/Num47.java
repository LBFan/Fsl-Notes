package com.fan.exam.jianzhioffer;

/**
 * @Description : 礼物的最大价值
 * @Author : shulin.fan
 * @Date : 2020/7/17
 */
public class Num47 {
    public static int getMost(int[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0) {
            return 0;
        }
        int n = values[0].length;
        int[] dp = new int[n];
        for (int[] value : values) {
            dp[0] += value[0];
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i], dp[i - 1]) + value[i];
            }
        }
        return dp[n - 1];
    }
}
