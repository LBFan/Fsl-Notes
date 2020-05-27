package leetcode.stackandqueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 循环数组中比当前元素大的下一个元素
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 * 与 739. Daily Temperatures (Medium) 不同的是，数组是循环数组，并且最后要求的不是距离而是下一个元素。
 * @date : 2020/02/26.
 */

public class Num06 {
    public int[] nextGreaterElementsByCyc(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> pre = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!pre.isEmpty() && nums[pre.peek()] < num) {
                next[pre.pop()] = num;
            }
            if (i < n) {
                pre.push(i);
            }
        }
        return next;
    }

    public int[] nextGreaterElementsByOfficial(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = (n << 1) - 1; i >= 0; i--) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % n]) {
                stack.pop();
            }
            res[i % n] = stack.empty() ? -1 : stack.peek();
            stack.push(i % n);
        }
        return res;
    }
}

