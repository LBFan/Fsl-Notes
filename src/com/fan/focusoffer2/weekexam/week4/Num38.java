package com.fan.focusoffer2.weekexam.week4;

import java.util.Stack;

/**
 * @author : PF_23
 * @Description : 每日温度，利用单调桟特性
 * @date : 2022/3/26 13:37.
 */

public class Num38 {

    public static int[] days(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            // 比较，单调递减桟
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                Integer pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {33, 31, 32, 36, 34};
        int[] days = days(nums);
        System.out.println(days);
    }
}

