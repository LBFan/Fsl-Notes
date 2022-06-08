package com.fan.exercisefocusoffer.arrs;

/**
 * @author : PF_23
 * @Description : 数组中重复的数字
 * @date : 2022/2/24 19:13.
 */

public class Num03 {
    public int duplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
            swap(nums, i, nums[i]);
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = { 0,1,2,3,4,5,6,7,8,2};
        Num03 num03 = new Num03();
        int duplicate = num03.duplicate(nums);
        System.out.println(duplicate);
    }
}

