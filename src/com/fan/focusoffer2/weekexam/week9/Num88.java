package com.fan.focusoffer2.weekexam.week9;

/**
 * @author : PF_23
 * @Description : 爬楼梯的最少成本
 * @date : 2022/5/21 10:18.
 */

public class Num88 {

    public static int minCost(int[] nums) {
        //关键是动态转移方程 f(i) = MIN(f(i - 1), f(i - 2)) + nums[i],可以从i- 2到i，也可以从 i- 1 到i，这就是说到i的最小代价是
        //i- 1 和 i- 2的最小值
        int[] dp = new int[2];
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        dp[0] = nums[0];
        // 题目允许从第一步楼梯往上爬
        dp[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            dp[i % 2] = Math.min(dp[(i - 1) % 2], dp[i % 2]) + nums[i];
        }

        return Math.min(dp[0], dp[1]);

    }

    public static void main(String[] args) {
        int[] nums = {1, 100, 1, 1, 100, 1};
        int minCost = minCost(nums);
        System.out.println(minCost);
    }
}

