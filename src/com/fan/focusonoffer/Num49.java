package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 丑数
 * 把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。习惯上我们把 1 当做是第一个丑数。求按从小到大的顺序的第 N 个丑数。
 * @date : 2019/12/30.
 */

public class Num49 {
    public int GetUglyNumber_Solution(int n) {
        if (n < 6) {
            return n;
        }
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

