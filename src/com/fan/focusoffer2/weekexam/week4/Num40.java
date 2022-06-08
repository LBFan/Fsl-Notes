package com.fan.focusoffer2.weekexam.week4;

import java.util.Stack;

/**
 * @author : PF_23
 * @Description : 矩阵的最大面积
 * @date : 2022/3/26 13:39.
 */

public class Num40 {
    public int maxArea(String[] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int maxArea = 0;
        // 构造不同的直方图，求最大面积
        int[] heights = new int[matrix[0].length()];
        for (String ints : matrix) {
            for (int i = 0; i < ints.length(); i++) {
                if (ints.charAt(i) == '0') {
                    heights[i] = 0;
                } else {
                    heights[i]++;
                }
            }
            maxArea = Math.max(maxArea, maxArea(heights));
        }
        return maxArea;
    }

    private int maxArea(int[] nums) {
        //关键在于求当前值为高的矩形面积
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        //
        stack.push(-1);
        for (int i = 0; i < nums.length; i++) {
            while (stack.peek() != -1 && nums[i] < nums[stack.peek()]) {
                int index = stack.pop();
                int weight = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, weight * nums[index]);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int index = stack.pop();
            int weight = nums.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, weight * nums[index]);
        }

        return maxArea;
    }
}

