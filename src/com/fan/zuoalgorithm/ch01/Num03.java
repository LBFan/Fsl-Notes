package com.fan.zuoalgorithm.ch01;

import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 如何仅用递归函数和桟操作逆序一个桟
 * @date : 2019/11/03.
 */

public class Num03 {
    /**
     * 逆序桟
     *
     * @param stack stack
     */
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    /**
     * 返回桟底元素，并将其余元素压入原桟
     *
     * @param stack stack
     * @return 桟底元素
     */
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("反转桟之前：");
        while (!stack.isEmpty()) {
            int i = stack.pop();
            System.out.print(i + "\t");
        }
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println();
        System.out.println("============================");
        System.out.println("反转桟之后：");
        reverse(stack);
        while (!stack.isEmpty()) {
            int i = stack.pop();
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}

