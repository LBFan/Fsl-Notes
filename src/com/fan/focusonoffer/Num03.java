package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 数组中重复的数 时间：O(N) 空间：O(1) 不能使用额外的空间 这里就限定了不能使用hash表
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * <p>
 * 总结： 像这种有说明  0 到 n-1 的范围内 的题，第一反应是能不能使用方法将num[i]放到i索引处解决
 * @date : 2019/12/12.
 */

public class Num03 {
    public static int duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0) {
            return -1;
//            return false;
        }
        for (int i = 0; i < length; i++) {
            // 如果相等就返回，否则交换
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    duplication[0] = nums[i];
                    return duplication[0];
//                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
//        return false;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 2};
        int[] dup = new int[1];
        int duplicate = duplicate(nums, nums.length, dup);
        System.out.println(duplicate);
    }
}

