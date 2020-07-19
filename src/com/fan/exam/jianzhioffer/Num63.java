package com.fan.exam.jianzhioffer;

/**
 * @Description : 股票的最大利润
 * 可以有一次买入和一次卖出，买入必须在前。求最大收益。
 * @Author : shulin.fan
 * @Date : 2020/7/19
 */
public class Num63 {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 0) {
            return 0;
        }
        int soFar = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            soFar = Math.min(prices[i], soFar);
            maxProfit = Math.max(maxProfit, prices[i] - soFar);
        }
        return maxProfit;
    }
}

