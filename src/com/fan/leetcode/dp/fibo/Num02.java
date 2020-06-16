package com.fan.leetcode.dp.fibo;

/**
 * @author :  PF_23
 * @Description : 强盗抢劫
 * 题目描述：抢劫一排住户，但是不能抢邻近的住户，求最大抢劫量。
 * 定义 dp 数组用来存储最大的抢劫量，其中 dp[i] 表示抢到第 i 个住户时的最大抢劫量。
 * <p>
 * 由于不能抢劫邻近住户，如果抢劫了第 i -1 个住户，那么就不能再抢劫第 i 个住户，所以
 * dp[i] =  max{dp[i - 2] + number[i], dp[i - 1]}
 * @date : 2020/01/06.
 */

public class Num02 {
    public int rob(int[] nums) {
        int pre2 = 0, pre1 = 0;
        int cur;
        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 1};
        int rob = new Num02().rob(nums);
        System.out.println(rob);
    }
}

