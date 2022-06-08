package com.fan.focusoffer2.weekexam.week7;

/**
 * @author : PF_23
 * @Description : 查找插入位置
 * @date : 2022/4/16 12:19.
 */

public class Num68 {

    public int insertIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 不在数组范围内，那插入到最后一位
        return nums.length;
    }
}

