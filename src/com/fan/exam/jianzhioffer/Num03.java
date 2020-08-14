package com.fan.exam.jianzhioffer;

/**
 * @Description : 数组中重复的数字
 * @Author : shulin.fan
 * @Date : 2020/7/13
 */
public class Num03 {
    public static int duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0) {
            return -1;
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] < 0 || nums[i] > length - 1) {
                return -1;
            }
        }

        for (int i = 0; i < length; i++) {
            // 相等则返回，不等则继续
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return duplication[0];
                }
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
