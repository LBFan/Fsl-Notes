package leetcode.greedy;

/**
 * @author :  PF_23
 * @Description : 买卖股票最大的收益
 * 题目描述：一次股票交易包含买入和卖出，只进行一次交易，求最大收益。
 * <p>
 * 只要记录前面的最小价格，将这个最小价格作为买入价格，然后将当前的价格作为售出价格，查看当前收益是不是最大收益。
 * @date : 2020/01/16.
 */

public class Num05 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int soFarMin = prices[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (soFarMin > prices[i]) {
                soFarMin = prices[i];
            } else {
                max = Math.max(max, prices[i] - soFarMin);
            }
        }
        return max;
    }
}

