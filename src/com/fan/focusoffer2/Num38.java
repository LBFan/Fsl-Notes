package com.fan.focusoffer2;

import java.util.Stack;

/**
 * @author : PF_23
 * @Description : 每日温度
 * @date : 2022/3/23 21:22.
 */

public class Num38 {

    /**
     * 给一个每日温度的数组，求出每天需要等几天才会出现更高的温度
     * 思路：
     * @param nums
     * @return
     */
    public int[] getTemp(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            // 第一个数字先放入桟中,注意，放入的是下标
            if (stack.isEmpty()) {
                stack.push(i);
            }

            // 比较，如果当前数字比栈顶元素大，说明栈顶元素所在的温度的下一个更高温度出现在当前元素处，出栈，并且记录栈顶的出现更高温度的天数
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                int index = stack.pop();
                res[index] = i - index;
            }

            // 如果当前元素比栈顶元素小，那就入栈
            stack.push(i);
        }

        return res;

    }
}

