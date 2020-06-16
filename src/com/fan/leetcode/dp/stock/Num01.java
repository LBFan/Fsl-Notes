package com.fan.leetcode.dp.stock;

/**
 * @author :  PF_23
 * @Description : 需要冷却期的股票交易
 * <p>
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * <p>
 * 示例:
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 题目描述：交易之后需要有一天的冷却时间。
 * @date : 2020/01/14.
 */

public class Num01 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
//        int[] buy = new int[n];
//        int[] s1 = new int[n];
//        int[] sell = new int[n];
//        int[] s2 = new int[n];
//        s1[0] = buy[0] = -prices[0];
//        sell[0] = s2[0] = 0;
//        for (int i = 1; i < n; i++) {
//            buy[i] = s2[i - 1] - prices[i];
//            int max = Math.max(buy[i - 1], s1[i - 1]);
//            s1[i] = max;
//            sell[i] = max + prices[i];
//            s2[i] = Math.max(s2[i - 1], sell[i - 1]);
//        }
//        return Math.max(sell[n - 1], s2[n - 1]);

        // 不持有时利润
        int dp_i_0 = 0;
        // 持有时利润
        int dp_i_1 = Integer.MIN_VALUE;
        // 前一个不持有时的利润，由于有冻结期，所以应该是i- 2
        int dp_pre_0 = 0;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = tmp;
        }
        return dp_i_0;
    }
}

