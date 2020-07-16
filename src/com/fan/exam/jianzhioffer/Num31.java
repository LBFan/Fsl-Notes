package com.fan.exam.jianzhioffer;

import java.util.Stack;

/**
 * @Description : 栈的压入、弹出序列 借助辅助栈
 * 如果下一个弹出的数字刚好是栈顶数字，那么直接弹出；
 * 如果下一个弹出的数字不在栈顶，则把压入序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止；
 * 如果所有数字都压入栈后仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列
 * @Author : shulin.fan
 * @Date : 2020/7/16
 */
public class Num31 {
    public static boolean isPopOrder(int[] push, int[] pop) {
        int n = push.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(push[pushIndex]);
            while (pushIndex < n && !stack.isEmpty() && stack.peek() == pop[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }

        return stack.isEmpty();
    }
}
