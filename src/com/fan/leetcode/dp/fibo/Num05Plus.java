package com.fan.leetcode.dp.fibo;

/**
 * @author :  PF_23
 * @Description : 头条面试 ： 母牛生产
 * 母牛从3-7岁初每年会生产1头小母牛，10岁后死亡（10岁仍然存活），
 * 假设初始有1头刚出生的母牛，请问第n年有多少头母牛？（年从第一年开始计数）
 * @date : 2020/01/06.
 */

public class Num05Plus {
    public int totalCows(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            if (i >= 3 && i <= 7) {
                sum = sum + dp[i - 2];
                dp[i] = sum + 1;
            } else if (i > 7 && i <= 10) {
                sum = sum - dp[i - 7] + dp[i - 2];
                dp[i] = sum + 1;
            } else { // 母牛死了，不再加1
                sum = sum - dp[i - 7] + dp[i - 2];
                dp[i] = sum;
            }
        }
        return dp[n];
    }
}

