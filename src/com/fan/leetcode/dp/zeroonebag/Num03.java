package com.fan.leetcode.dp.zeroonebag;

import static com.fan.leetcode.dp.zeroonebag.Num02.computeArraySum;

/**
 * @author :  PF_23
 * @Description : 改变一组数的正负号使得它们的和为一给定数
 * <p>
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * <p>
 * 该问题可以转换为 Subset Sum 问题，从而使用 0-1 背包的方法来求解。
 * <p>
 * 可以将这组数看成两部分，P 和 N，其中 P 使用正号，N 使用负号，有以下推导：
 * <p>
 * ------------------sum(P) - sum(N) = target
 * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
 * -----------------------2 * sum(P) = target + sum(nums)
 * 因此只要找到一个子集，令它们都取正号，并且和等于 (target + sum(nums))/2，就证明存在解。
 * @date : 2020/01/13.
 */

public class Num03 {

    public int findTargetSumWays(int[] nums, int S) {
        int sum = computeArraySum(nums);
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int W = (sum + S) / 2;
        int[] dp = new int[W + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = W; i >= num; i++) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[W];
    }

    /**
     * DFS
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWaysByDFS(int[] nums, int S) {
        return findTargetSumWays(nums, 0, S);
    }

    private int findTargetSumWays(int[] nums, int start, int S) {
        if (start == nums.length) {
            return S == 0 ? 1 : 0;
        }
        return findTargetSumWays(nums, start + 1, S + nums[start])
                + findTargetSumWays(nums, start + 1, S - nums[start]);
    }
}

