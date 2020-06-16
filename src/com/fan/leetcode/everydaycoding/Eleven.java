package com.fan.leetcode.everydaycoding;

/**
 * @author :  PF_23
 * @Description : 盛最多水的容器
 * n>= 2
 * @date : 2020/04/18.
 */

public class Eleven {
    public static int maxArea(int[] height) {
        int le = 0, ri = height.length - 1;
        int max = 0;
        int cur;
        while (le < ri) {
            if (height[le] > height[ri]) {
                cur = (ri - le) * height[ri];
                max = Math.max(max, cur);
                ri--;
            } else {
                cur = (ri - le) * height[le];
                max = Math.max(max, cur);
                le++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea(height);
        System.out.println(maxArea);
    }
}

