package com.fan.interviewgold.cha08;

/**
 * @author :  PF_23
 * @Description : 硬币
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 * <p>
 * 示例1:
 * <p>
 * 输入: n = 5
 * 输出：2
 * 解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 * <p>
 * 输入: n = 10
 * 输出：4
 * 解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * @date : 2020/04/08.
 */

public class Eleven {

    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        int[] coins = {1, 5, 10, 25};

        // 第一行
        for (int i = 0; i <= n; i++) {
            dp[i] = 1;
        }

        // 第2种~第4种硬币（4 - 1 = 3轮）
        for (int i = 1; i < 4; i++) {
            // 每一轮都遍历从1~n分钱的种数
            for (int j = 1; j <= n; j++) {
                if (j >= coins[i]) {
                    dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;
                }
            }
        }
        return dp[n];
    }
}

