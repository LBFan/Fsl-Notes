package com.fan.exam.jianzhioffer;

/**
 * @Description : 在排序数组中查找数字出现的次数
 * @Author : shulin.fan
 * @Date : 2020/7/18
 */
public class Num53 {
    public static int getNumberOfK(int[] nums, int target) {
        int findFirst = binarySearch(nums, target);
        int findLast = binarySearch(nums, target + 1);
        return (findFirst == nums.length || nums[findFirst] != target) ? 0 : findLast - findFirst;
    }

    /**
     * 返回数组中小于target的个数
     *
     * @param nums
     * @param target
     * @return
     */
    private static int binarySearch(int[] nums, int target) {
        int l = 0, h = nums.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] >= target) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;

    }
}
