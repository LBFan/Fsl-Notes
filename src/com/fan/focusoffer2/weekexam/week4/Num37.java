package com.fan.focusoffer2.weekexam.week4;

import java.util.Stack;

/**
 * @author : PF_23
 * @Description : 小行星碰撞，负数向左，正数向右
 * @date : 2022/3/26 13:19.
 */

public class Num37 {
    //利用桟
    public int[] getValue(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -num) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() == -num) {
                stack.pop();
            } else if (stack.isEmpty() || stack.peek() < 0 || num > 0) {
                stack.push(num);
            }
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }
}

