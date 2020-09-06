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
    /**
     * 我的解法
     *
     * @param push
     * @param pop
     * @return
     */
    public static boolean isPopOrder(int[] push, int[] pop) {
        int n = push.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(push[pushIndex]);
            while (!stack.isEmpty() && stack.peek() == pop[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 大神的解法
     *
     * @param push
     * @param pop
     * @return
     */
    public static boolean isPopOrder2(int[] push, int[] pop) {
        int i = 0, j = 0;
        // 以下其实就是在模拟栈的入栈和出栈
        for (int e : push) {
            push[i] = e;
            while (i >= 0 && push[i] == pop[j]) {
                i--;
                j++;
            }
            i++;
        }
        return i == 0;
    }

    public static void main(String[] args) {
//        int[] push = {1, 2, 3, 4, 5};
//        int[] pop = {4, 5, 3, 2, 1};
//        boolean popOrder = isPopOrder(push, pop);
//        System.out.println(popOrder);
        Integer i = 1, j = 1;
        System.out.println(i == j);
        System.out.println(i.equals(j));

        Integer m = 200, n = 200;
        System.out.println(m == n);
        System.out.println(m.equals(n));

    }
}
