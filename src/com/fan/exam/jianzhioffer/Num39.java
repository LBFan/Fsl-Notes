package com.fan.exam.jianzhioffer;

/**
 * @Description : 数组中出现次数超过一半的数字
 * 多数投票问题，可以利用 Boyer-Moore Majority Vote Algorithm 来解决这个问题，使得时间复杂度为 O(N)。
 * @Author : shulin.fan
 * @Date : 2020/7/16
 */
public class Num39 {
    public static int MoreThanHalfNum_Solution(int[] nums) {
        int majority = nums[0];
        for (int i = 1, cnt = 1; i < nums.length; i++) {
            if (cnt == 0) {
                cnt = 1;
                majority = nums[i];
            }
            cnt = (majority == nums[i]) ? cnt + 1 : cnt - 1;
        }
        int count = 0;
        for (int num : nums) {
            if (num == majority) {
                count++;
            }
        }
        return count > nums.length / 2 ? majority : -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int i = MoreThanHalfNum_Solution(nums);
        System.out.println(i);
    }
}
