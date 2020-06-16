package com.fan.leetcode.dp.zeroonebag;

/**
 * @author :  PF_23
 * @Description : 找零钱的最少硬币数
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * <p>
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * 题目描述：给一些面额的硬币，要求用这些硬币来组成给定面额的钱数，并且使得硬币数量最少。硬币可以重复使用。
 * <p>
 * 物品：硬币
 * 物品大小：面额
 * 物品价值：数量
 * 因为硬币可以重复使用，因此这是一个完全背包问题。完全背包只需要将 0-1 背包的逆序遍历 dp 数组改为正序遍历即可。
 * @date : 2020/01/13.
 */

public class Num05 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            //将逆序遍历改为正序遍历
            for (int i = coin; i <= amount; i++) {
                if (i == coin) {
                    dp[i] = 1;
                } else if (dp[i] == 0 && dp[i - coin] != 0) {
                    dp[i] = dp[i - coin] + 1;
                } else if (dp[i - coin] != 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}

