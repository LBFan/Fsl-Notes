package com.fan.exam.jianzhioffer;

/**
 * @Description :剪绳子
 * @Author : shulin.fan
 * @Date : 2020/7/14
 */
public class Num14 {
    public static int integerBreak(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int threeTimes = n / 3;
        if (n % 3 == 1) {
            threeTimes--;
        }
        int twoTimes = (n - threeTimes * 3) / 2;
        return (int) (Math.pow(3, threeTimes) * Math.pow(2, twoTimes));
    }

    /**
     * DP
     *
     * @param n 绳长
     * @return 最大乘积
     */
    public static int integerByDp(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[j] * (i - j), j * (i - j)));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 11;
        int i = integerBreak(n);
        System.out.println(i);
    }
}
