package com.fan.exam.jianzhioffer;

/**
 * @Description : 调整数组位置使奇数位于偶数前面
 * @Author : shulin.fan
 * @Date : 2020/7/15
 */
public class Num21 {
    public static int[] reOrderOddEvent(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return nums;
        }

        // 统计奇数个数
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = nums[i] % 2 == 1 ? count + 1: count;
        }

        int i = 0, j = count;
        int[] copy = nums.clone();
        for (int n : nums) {
            if (n % 2 == 1) {
                copy[i++] = n;
            } else {
                copy[j++] = n;
            }
        }
        return copy;
    }

    // 方法2： 双指针，左边和右边向中间走，左遇到偶数和右边遇到奇数时，交换
}
