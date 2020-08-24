package com.fan.exam.jianzhioffer;

/**
 * @Description : 数组中出现次数超过一半的数字
 * 多数投票问题，可以利用 Boyer-Moore Majority Vote Algorithm 来解决这个问题，使得时间复杂度为 O(N)。
 * @Author : shulin.fan
 * @Date : 2020/7/16
 */
public class Num39 {
    public static int moreThanHalfNum_Solution(int[] nums) {
        int majority = nums[0];
        for (int i = 1, cnt = 1; i < nums.length; i++) {
            cnt = (majority == nums[i]) ? cnt + 1 : cnt - 1;
            if (cnt == 0) {
                cnt = 1;
                majority = nums[i];
            }
        }
        int count = 0;
        for (int num : nums) {
            if (num == majority) {
                count++;
            }
        }
        return count > nums.length / 2 ? majority : -1;
    }

    /**
     * 大神解法
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;
        }
        return x;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int i = moreThanHalfNum_Solution(nums);
        System.out.println(i);
    }
}
