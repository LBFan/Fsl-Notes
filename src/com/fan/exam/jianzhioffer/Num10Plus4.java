package com.fan.exam.jianzhioffer;

import java.util.Arrays;

/**
 * @Description : 变态跳台阶
 * @Author : shulin.fan
 * @Date : 2020/7/13
 */
public class Num10Plus4 {
    public int JumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target - 1];
    }

    /**
     * 法2
     *
     * @param n
     * @return
     */
    public static int JumpFloorIIMethodII(int n) {
        return (int) Math.pow(2, n - 1);
    }
}
