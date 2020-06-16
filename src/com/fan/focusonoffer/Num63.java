package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 股票的最大利润
 * 可以有一次买入和一次卖出，买入必须在前。求最大收益。
 * <p>
 * 思路：
 * 使用贪心策略，假设第 i 轮进行卖出操作，买入操作价格应该在 i 之前并且价格最低
 * @date : 2019/12/31.
 */

public class Num63 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int soFar = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            soFar = Math.min(prices[i], soFar);
            maxProfit = Math.max(maxProfit, prices[i] - soFar);
        }
        return maxProfit;
    }
}

