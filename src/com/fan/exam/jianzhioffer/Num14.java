package com.fan.exam.jianzhioffer;

/**
 * @Description :剪绳子 (考虑大数)
 * @Author : shulin.fan
 * @Date : 2020/7/14
 */
public class Num14 {
    public static int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }

        long res = 1;
        int mod = 1000000007;
        while (n > 4) {
            res *= 3;
            res %= mod;
            n -= 3;
        }
        return (int) (res * n % mod);

        //if(n <= 3) {
        //    return n - 1;
        //}
        //int a = n / 3, b = n % 3;
        //if(b == 0) {
        //    return (int)Math.pow(3, a);
        //}
        //if(b == 1) {
        //    return (int)Math.pow(3, a - 1) * 4;
        //}
        //return (int)Math.pow(3, a) * 2;

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
