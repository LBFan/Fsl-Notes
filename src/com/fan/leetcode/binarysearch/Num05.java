package com.fan.leetcode.binarysearch;

/**
 * @author :  PF_23
 * @Description : 旋转数组的最小数字
 * Input: [3,4,5,1,2],
 * Output: 1
 * @date : 2020/02/09.
 */

public class Num05 {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid = (l + h) >>> 1;
            if (nums[mid] > nums[h]) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return nums[l];
    }
}

