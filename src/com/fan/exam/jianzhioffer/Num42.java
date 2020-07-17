package com.fan.exam.jianzhioffer;

/**
 * @Description : 连续子数组的最大和
 * @Author : shulin.fan
 * @Date : 2020/7/17
 */
public class Num42 {
    public static int findGreatestSumOfSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int generateSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum <= 0 ? nums[i] : nums[i] + sum;
            generateSum = Math.max(generateSum, sum);
        }
        return generateSum;
    }
}
