package com.fan.focusoffer2.weekexam.week7;

/**
 * @author : PF_23
 * @Description : 山峰数组的顶部
 * @date : 2022/4/16 12:23.
 */

public class Num69 {
    public int getTop(int[] nums) {
        // 二分查找
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

