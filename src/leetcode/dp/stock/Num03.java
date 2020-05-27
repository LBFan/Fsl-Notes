package leetcode.dp.stock;

/**
 * @author :  PF_23
 * @Description : 只能进行两次的股票交易
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * @date : 2020/01/14.
 */

public class Num03 {
    public int maxProfit(int[] prices) {
//        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
//        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
//        for (int curPrice : prices) {
//            if (firstBuy < -curPrice) {
//                firstBuy = -curPrice;
//            }
//            if (firstSell < firstBuy + curPrice) {
//                firstSell = firstBuy + curPrice;
//            }
//
//            if (secondBuy < firstSell - curPrice) {
//                secondBuy = firstSell - curPrice;
//            }
//
//            if (secondSell < secondBuy + curPrice) {
//                secondSell = secondBuy + curPrice;
//            }
//        }
//        return secondSell;
        /**
         对于任意一天考虑四个变量:
         fstBuy: 在该天第一次买入股票可获得的最大收益
         fstSell: 在该天第一次卖出股票可获得的最大收益
         secBuy: 在该天第二次买入股票可获得的最大收益
         secSell: 在该天第二次卖出股票可获得的最大收益
         分别对四个变量进行相应的更新, 最后secSell就是最大
         收益值(secSell >= fstSell)
         **/
        int fstBuy = Integer.MIN_VALUE, fstSell = 0;
        int secBuy = Integer.MIN_VALUE, secSell = 0;
        for (int p : prices) {
            fstBuy = Math.max(fstBuy, -p);
            fstSell = Math.max(fstSell, fstBuy + p);
            secBuy = Math.max(secBuy, fstSell - p);
            secSell = Math.max(secSell, secBuy + p);
        }
        return secSell;
    }
}
