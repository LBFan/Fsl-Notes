package com.fan.focusoffer2.weekexam.week7;

/**
 * @author : PF_23
 * @Description : 排序数组汇总只出现一次的数字
 * @date : 2022/4/16 12:30.
 */

public class Num70 {

    public int once(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            // 比较当前数字和后面数字是否相同
            // 求i主要是求出当前的数字对，如果当前数字对不等，前面的数字对相同，那么当前下标就是只出现一次的数字
            int i = mid >> 1;

            if (i < nums.length - 1 && nums[i] != nums[i + 1]) {
                if (mid == 0 || nums[i - 1] == nums[i - 2]) {
                    return nums[i];
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return nums[nums.length - 1];
    }
}

