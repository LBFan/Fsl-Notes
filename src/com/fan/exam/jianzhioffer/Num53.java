package com.fan.exam.jianzhioffer;

/**
 * @Description : 在排序数组中查找数字出现的次数
 * @Author : shulin.fan
 * @Date : 2020/7/18
 */
public class Num53 {
    public static int getNumberOfK(int[] nums, int k) {
        int findFirst = binarySearch(nums, k);
        int findLast = binarySearch(nums, k + 1);
        return (findFirst == nums.length || nums[findFirst] != k) ? 0 : findLast - findFirst;
    }

    private static int binarySearch(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] >= k) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;

    }
}
