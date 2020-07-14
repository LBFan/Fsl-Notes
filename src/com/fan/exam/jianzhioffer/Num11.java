package com.fan.exam.jianzhioffer;

/**
 * @Description : 旋转数组的最小数字 （需要考虑是否有重复数字）
 * @Author : shulin.fan
 * @Date : 2020/7/14
 */
public class Num11 {

    /**
     * 升序（无重复）：二分法
     *
     * @param nums 旋转数组
     * @return 最小值
     */
    public static int min(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int le = 0, hi = nums.length - 1;
        while (le < hi) {
            int mid = (hi - le) / 2 + le;
            if (nums[mid] >= nums[le]) {
                le = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[le];
    }

    /**
     * 升序（有重复）：二分法
     *
     * @param nums 旋转数组
     * @return 最小值
     */
    public static int minWithSame(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int le = 0, hi = nums.length - 1;
        while (le < hi) {
            int mid = (hi - le) / 2 + le;
            if (nums[mid] == nums[le] && nums[le]== nums[hi]) {
                return findMin(nums, le,hi);
            }else if (nums[mid] <= nums[hi]) {
                hi = mid;
            } else {
                // mid > hi :最小值肯定在mid + 1 ~ hi 之间
                le = mid + 1;
            }
        }
        return nums[le];
    }

    private static int findMin(int[] nums, int le, int hi) {
        for (int i = le; i < hi; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[le];
    }
}
