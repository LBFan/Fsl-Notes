package com.fan.iqiyi;

import java.util.Scanner;

/**
 * @Description : 判断字符串括号是否有效
 * 题目描述：
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 1. 左括号必须用相同类型的右括号闭合。
 * <p>
 * 2. 左括号必须以正确的顺序闭合。
 * <p>
 * 注意空字符串可被认为是有效字符串。
 * 输入描述
 * 一个字符串，仅包含括号'('，')'，'{'，'}'，'['，']'
 * <p>
 * 输出描述
 * 如果字符串验证有效，返回 True
 * <p>
 * 如果字符串验证无效，返回 False
 * @Author : shulin.fan
 * @Date : 2020/8/23
 */
public class Main03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    private static boolean isValid(String s) {
        if (s.length() == 0) {
            return false;
        }
        char[] stack = new char[s.length()];
        int i = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack[i++] = ch;
            } else if (ch == ')' && i > 0 && stack[i - 1] == '(') {
                i--;
            } else if (ch == ']' && i > 0 && stack[i - 1] == '[') {
                i--;
            } else if (ch == '}' && i > 0 && stack[i - 1] == '{') {
                i--;
            } else {
                return false;
            }
        }
        return i == 0;
    }

}
