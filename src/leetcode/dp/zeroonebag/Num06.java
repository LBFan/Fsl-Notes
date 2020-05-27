package leetcode.dp.zeroonebag;

/**
 * @author :  PF_23
 * @Description : 找零钱的硬币数组合
 * <p>
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 完全背包问题，使用 dp 记录可达成目标的组合数目
 * @date : 2020/01/13.
 */

public class Num06 {
    public int change(int amount, int[] coins) {
        if (coins == null) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}

