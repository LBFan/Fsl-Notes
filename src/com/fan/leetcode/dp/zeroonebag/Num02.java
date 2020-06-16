package com.fan.leetcode.dp.zeroonebag;

/**
 * @author :  PF_23
 * @Description : 划分数组为和相等的两部分
 * <p>
 * Input: [1, 5, 11, 5]
 * Output: true
 * <p>
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * <p>
 * 思路：
 * 可以看成一个背包大小为 sum/2 的 0-1 背包问题。
 * @date : 2020/01/13.
 */

public class Num02 {
    public boolean canPartition(int[] nums) {
        int sum = computeArraySum(nums);
        if (sum % 2 == 1) {
            return false;
        }
        int W = sum / 2;
        boolean[] dp = new boolean[W + 1];
        dp[0] = true;
        // 0-1 背包一个物品只能用一次
        for (int num : nums) {
            // 从后往前，先计算 dp[i] 再计算 dp[i-num]
            for (int i = W; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[W];
    }

    public static int computeArraySum(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum;
    }
}

