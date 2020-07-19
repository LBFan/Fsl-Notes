package com.fan.exam.jianzhioffer;

import java.util.Arrays;

/**
 * @Description : 扑克牌中的顺子
 * @Author : shulin.fan
 * @Date : 2020/7/19
 */
public class Num61 {
    public static boolean isContinuous(int[] nums) {
        if (nums.length < 5) {
            return false;
        }
        // 癞子
        int count = 0;
        for (int num : nums) {
            count = num == 0 ? count + 1 : count;
        }

        for (int i = count; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                return false;
            }
            count -= nums[i] - nums[i - 1] + 1;
        }
        return count >= 0;
    }
}
