package com.fan.focusoffer2.weekexam.week9;

/**
 * @author : PF_23
 * @Description : 环形房屋偷盗
 * @date : 2022/5/21 10:18.
 */

public class Num90 {
    // 防止首尾相连
    public static int maxCost(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length < 3) {
            return Math.max(nums[0], nums[1]);
        }

        int result1 = help(nums, 0, nums.length - 2);
        int result2 = help(nums, 1, nums.length - 1);
        return Math.max(result1, result2);
    }

    private static int help(int[] nums, int start, int end) {
        int[] dp = new int[2];
        dp[0] = nums[start];
        if (start < end) {
            dp[1] = Math.max(nums[start], nums[start + 1]);
        }
        for (int i = start + 2; i <= end; i++) {
            int j = i - start;
            dp[j % 2] = Math.max(dp[(j - 1) % 2], dp[j % 2] + nums[i]);
        }
        return dp[(end - start) % 2];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 5, 7, 6, 6};
        int maxCost = maxCost(nums);
        System.out.println(maxCost);
    }
}

