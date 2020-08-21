package com.fan.leetcode.favorate;

/**
 * @Description : 在排序数组中查找元素的第一个和最后一个位置
 * @Author : shulin.fan
 * @Date : 2020/8/19
 */
public class Num21 {

    /**
     * 两次二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        int leftIndex = binarySearch(nums, target, true);

        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return targetRange;
        }
        targetRange[0] = leftIndex;
        targetRange[1] = binarySearch(nums, target, false);
        return targetRange;
    }

    /**
     * 二分查找
     *
     * @param nums   数组
     * @param target 目标值
     * @param left   true ? 左边界 : 右边界
     * @return
     */
    private int binarySearch(int[] nums, int target, boolean left) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {

                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
