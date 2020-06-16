package com.fan.leetcode.stackandqueue;

import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 数组中元素与下一个比它大的元素之间的距离
 * 在遍历数组时用栈把数组中的数存起来，如果当前遍历的数比栈顶元素来的大，说明栈顶元素的下一个比它大的数就是当前元素。
 * @date : 2020/02/26.
 */

public class Num05 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] dist = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int curIndex = 0; curIndex < n; curIndex++) {
            while (!stack.isEmpty() && temperatures[curIndex] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                dist[preIndex] = curIndex - preIndex;
            }
            stack.push(curIndex);
        }
        return dist;
    }

}

