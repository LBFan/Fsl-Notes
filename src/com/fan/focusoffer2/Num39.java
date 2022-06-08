package com.fan.focusoffer2;

import java.util.Stack;

/**
 * @author : PF_23
 * @Description : 直方图最大矩形面积
 * @date : 2022/3/23 21:42.
 */

public class Num39 {

    /**
     * 思路：利用桟，依次求出
     *
     * @param heights
     * @return
     */
    public int maxArea(int[] heights) {
        return extracted(heights);
    }

    public static int extracted(int[] heights) {
        int max = -1;
        Stack<Integer> stack = new Stack<>();
        // 先将桟中放入一个下标-1
        stack.push(-1);

        for (int i = 0; i < heights.length; i++) {
            // 找到了当前栈顶数字右边第一个更小的数
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                // 栈顶元素对应的高度
                int high = heights[stack.pop()];
                // 以栈顶下标元素为高的最大矩阵乘积
                max = Math.max(max, (i - stack.peek() - 1) * high);
            }
            stack.push(heights[i]);
        }

        // 桟中还有其他数字时，需要使用while计算得出最大乘积
        while (stack.peek() != -1) {
            int high = heights[stack.pop()];
            max = Math.max(max, high * (heights.length) - stack.peek() - 1);
        }

        return max;
    }
}

