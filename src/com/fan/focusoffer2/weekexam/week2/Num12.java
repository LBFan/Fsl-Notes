package com.fan.focusoffer2.weekexam.week2;

/**
 * @author : PF_23
 * @Description : 左右两边子数组的和相等
 * @date : 2022/3/12 09:24.
 */

public class Num12 {

    /**
     * 思路：下标为i的左边和表示出来，右边和表示出来，如果相等，就返回i
     * @param nums
     * @return
     */
    public int equalSum(int[] nums) {
        int totalSum = 0;
        // 整个数组的和
        for (int num : nums) {
            totalSum += num;
        }

        // 记录从第一个下标开始时连续到i下标的连续子数组的和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 表示的就是i左右两边的子数组的和
            if (sum - nums[i] == totalSum - sum) {
                return i;
            }
        }

        return -1;
    }
}

