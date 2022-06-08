package com.fan.focusoffer2.weekexam.week9;

/**
 * @author : PF_23
 * @Description : 房屋偷盗
 * @date : 2022/5/21 10:18.
 */

public class Num89 {
    public static int maxCost(int[] nums) {
        // f(i) = max(f(i - 1), f(i| - 2) + nums[i])
        int[] dp = new int[2];
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[i % 2] + nums[i]);
        }

        return dp[(nums.length - 1) % 2];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int maxCost = maxCost(nums);
        System.out.println(maxCost);
    }
}

