package com.fan.leetcode.everydaycoding;

/**
 * @author :  PF_23
 * @Description : 跳跃游戏
 * @date : 2020/04/17.
 */

public class FiftyFive {

    /**
     * 贪心算法
     *
     * @param nums 数组
     * @return 能到达：true 不能到达：false
     */
    public boolean canJump01(int[] nums) {
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 回溯算法
     *
     * @param nums 数组
     * @return 能到达：true 不能到达：false
     */
    public boolean canJump02(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        return backtrack(nums, 0, nums.length - 1);
    }

    private boolean backtrack(int[] nums, int s, int e) {
        for (int i = e - 1; i >= s; i--) {
            if (nums[i] == 0) {
                if (i == 0) {
                    return false;
                }
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] > (i - j)) {
                        return backtrack(nums, 0, j);
                    }
                }
                return false;
            }
        }
        return true;
    }
}

