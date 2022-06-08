package com.fan.focusoffer2;

import java.util.Stack;

/**
 * @author : PF_23
 * @Description : 后缀表达式求值
 * @date : 2022/3/23 20:54.
 */

public class Num36 {

    /**
     * 输入一个字符串数组，求表达式的值
     * 思路：如果是数字就放入桟中，如果是运算符，就出栈两个数字计算，然后入栈
     * @param tokens
     * @return
     */
    public int getResult(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(calculate(num2, num1, token));
                    break;
                default:
                    // 数字，直接入栈
                    stack.push(Integer.parseInt(token));

            }
        }

        return stack.pop();
    }

    private Integer calculate(int num2, int num1, String token) {
        switch (token) {
            case "+":
                return num2 + num1;
            case "-":
                return num2 - num1;
            case "*" :
                return num2 * num1;
            case "/":
                return num2 / num1;
            default:
                return 0;
        }
    }
}

