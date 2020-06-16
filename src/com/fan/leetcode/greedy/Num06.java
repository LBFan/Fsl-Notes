package com.fan.leetcode.greedy;

/**
 * @author :  PF_23
 * @Description : 买卖股票的最大收益 II
 * 题目描述：可以进行多次交易，多次交易之间不能交叉进行，可以进行多次交易。
 * <p>
 * 对于 [a, b, c, d]，如果有 a <= b <= c <= d ，那么最大收益为 d - a。而 d - a = (d - c) + (c - b) + (b - a) ，
 * 因此当访问到一个 prices[i] 且 prices[i] - prices[i-1] > 0，那么就把 prices[i] - prices[i-1] 添加到收益中。
 * @date : 2020/01/16.
 */

public class Num06 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}

