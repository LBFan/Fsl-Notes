package com.fan.zuoalgorithm.ch01;

import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 用一个桟实现另一个桟的排序
 * 将要排序的栈记为stack，申请的辅助栈记为help。在stack上执行pop操作，弹出的元素记为cur。
 *     （1）如果cur小于或等于help的栈顶元素，则将cur直接压入help；
 *      （2）如果cur大禹help的栈顶元素，则将该help的元素逐一弹出，逐一压入stack栈，
 * 直到cur小于或等于help的栈顶元素，再将 cur压入help
 * @date : 2019/11/03.
 */

public class Num05 {
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }

        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }


}

