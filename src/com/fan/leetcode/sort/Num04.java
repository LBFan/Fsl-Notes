package com.fan.leetcode.sort;

/**
 * @author :  PF_23
 * @Description : 荷兰国旗问题
 * 荷兰国旗包含三种颜色：红、白、蓝。
 * <p>
 * 有三种颜色的球，算法的目标是将这三种球按颜色顺序正确地排列。
 * 它其实是三向切分快速排序的一种变种，在三向切分快速排序中，
 * 每次切分都将数组分成三个区间：小于切分元素、等于切分元素、大于切分元素，
 * 而该算法是将数组分成三个区间：等于红色、等于白色、等于蓝色。
 * <p>
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 题目描述：只有 0/1/2 三种颜色。
 * @date : 2020/02/20.
 */

public class Num04 {
    public void sortColors(int[] nums) {
        int zero = -1, one = 0, two = nums.length;
        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, ++zero, one++);
            } else if (nums[one] == 2) {
                swap(nums, --two, one);
            } else {
                one++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        Num04 num04 = new Num04();
        num04.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

