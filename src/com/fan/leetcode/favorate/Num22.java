package com.fan.leetcode.favorate;

/**
 * @Description : 搜索插入位置 即查找排序数组中比目标值小的数字个数
 * @Author : shulin.fan
 * @Date : 2020/8/19
 */
public class Num22 {
    public static int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7};
        int target = 8;
        int searchInsert = searchInsert(nums, target);
        System.out.println(searchInsert);
    }
}
