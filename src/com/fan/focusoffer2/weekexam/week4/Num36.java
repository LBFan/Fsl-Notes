package com.fan.focusoffer2.weekexam.week4;

import java.util.Stack;

/**
 * @author : PF_23
 * @Description : 后缀表达式
 * @date : 2022/3/26 13:09.
 */

public class Num36 {

    public int getValue(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String c : tokens) {
            switch (c) {
                case "+":
                case "-":
                case "*":
                case "/":
                    calculate(stack, c);
                    break;
                default:
                    stack.push(Integer.parseInt(c));
            }
        }

        return stack.peek();
    }

    private void calculate(Stack<Integer> stack, String c) {
        int num1 = stack.pop();
        int num2 = stack.pop();
        switch (c) {
            case "+":
                stack.push(num2 + num1);
                break;
            case "-":
                stack.push(num2 - num1);
                break;
            case "*":
                stack.push(num2 * num1);
                break;
            case "/":
                stack.push(num2 / num1);
                break;
        }
    }
}

