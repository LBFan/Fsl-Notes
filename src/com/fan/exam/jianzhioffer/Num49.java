package com.fan.exam.jianzhioffer;

/**
 * @Description : 丑数
 * @Author : shulin.fan
 * @Date : 2020/7/17
 */
public class Num49 {

    public static int getUglyNumber(int index) {
        if (index  <= 0) {
            return 0;
        }
        int number = 0;
        int uglyFound = 0;
        while (uglyFound < index) {
            ++number;
            if (isUgly(number)) {
                uglyFound++;
            }
        }
        return number;
    }

    public static boolean isUgly(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }

    /**改进 : 空间换时间 DP
     * @param n n
     * @return
     */
    public int nthUglyNumber(int n) {
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int next2= dp[i2] * 2, next3 = dp[i3] * 3, next5 = dp[i5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2) {
                i2++;
            }
            if (dp[i] == next3) {
                i3++;
            }
            if (dp[i] == next5) {
                i5++;
            }
        }
        return dp[n - 1];
    }
}
