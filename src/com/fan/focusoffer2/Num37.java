package com.fan.focusoffer2;

import java.util.Stack;

/**
 * @author : PF_23
 * @Description : 小行星碰撞
 * @date : 2022/3/23 21:04.
 */

public class Num37 {

    /**
     * 思路：利用桟保存遍历过程中的数字，按照规则爆炸（去掉）数字。
     * 如果第一个小行星向右飞行（正数），先将其入栈，如果后面也是向右，就继续入栈，
     * 然后如果出现向左飞行的，就比较，不断比较，总有要爆炸的或者两者同时爆炸（大小相同，方向相反）
     * @param nums
     * @return
     */
    public int[] getResult(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            // 如果桟不为空，并且栈顶元素大小小于当前元素，方向相反，则出栈
             while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -num) {
                 stack.pop();
             }
             // 直到不满足为止，这里会有两种情况，大小相同，反向相反, 栈顶元素出栈
            if (!stack.isEmpty() && stack.peek() == -num) {
                stack.pop();
            } else if (num > 0 || stack.isEmpty() || stack.peek() < 0) {
                // 当前是正数，或者当前桟是空桟，或者当前栈顶元素是负数（是负数时不管当前元素是正数还是负数都不会碰撞，所以可以直接入栈）
                stack.push(num);
            }
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }
}

