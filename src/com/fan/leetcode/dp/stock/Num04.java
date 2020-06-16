package com.fan.leetcode.dp.stock;

/**
 * @author :  PF_23
 * @Description : 只能进行 k 次的股票交易
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * @date : 2020/01/14.
 */

public class Num04 {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices == null || prices.length < 2) {
            return 0;
        }

        int n = prices.length;
        // 不限交易次
        if (k > (n >> 1)) {
            int maxPro = 0;
            for (int i = 0; i < n - 1; i++) {
                int today = prices[i];
                int tomorrow = prices[i + 1];
                if (today < tomorrow) {
                    maxPro += tomorrow - today;
                }
            }
            return maxPro;
        }
        int[] sells = new int[k];
        int[] buys = new int[k];
        for (int i = 0; i < k; i++) {
            sells[i] = 0;
            buys[i] = Integer.MIN_VALUE;
        }

        for (int price : prices) {
            for (int i = 0; i < k; i++) {
                if (i == 0) {
                    sells[i] = Math.max(sells[i], buys[i] + price);
                    buys[i] = Math.max(buys[i], -price);
                    continue;
                }
                sells[i] = Math.max(sells[i], buys[i] + price);
                buys[i] = Math.max(buys[i], sells[i - 1] - price);
            }
        }
        return sells[k - 1];
    }
}

