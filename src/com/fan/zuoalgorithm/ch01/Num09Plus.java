package com.fan.zuoalgorithm.ch01;

/**
 * @author :  PF_23
 * @Description : 接雨水 LeetCode42
 * @date : 2019/11/08.
 */

public class Num09Plus {
    /**
     * 双指针法
     *
     * @param height 📊柱状图
     * @return 雨滴数
     */
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int res = 0;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }
}

