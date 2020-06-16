package com.fan.rice;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/04/09.
 */

public class OneFourOSix {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];

        dp[n] = 0;
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            //由于有负值分数，这里注意一下
            dp[i] = Integer.MIN_VALUE;
            sum += stoneValue[i];
            for (int j = i; j < i + 3 && j < n; j++) {
                dp[i] = Math.max(dp[i], sum - dp[j + 1]);
            }
        }
        int alice = dp[0];
        int bob = sum - dp[0];
        if (alice == bob) {
            return "Tie";
        }
        if (alice > bob) {
            return "Alice";
        }
        return "Bob";
    }
}

