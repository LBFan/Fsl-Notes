package com.fan.kuaishou;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 数字0-9，运算符+-*"/", 左右括号（）
 * AC
 * @date : 2020/04/1 .
 */

public class Main01 {

    private Stack<Character> stackOk = new Stack<>();
    private Stack<Character> stackRi = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        String s = scanner.nextLine();
        Main01 main = new Main01();
        int[] res = main.main(s);
        for (int ele : res) {
            System.out.print(ele + " ");
        }
    }

    public int[] main(String s) {
        int[] res = new int[3];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                if (s.charAt(i) == '(') {
                    stackOk.push(s.charAt(i));
                } else if (s.charAt(i) == ')') {
                    // 匹配桟为空，加入到右括号桟中
                    if (stackOk.isEmpty()) {
                        stackRi.push(s.charAt(i));
                    } else {
                        stackOk.pop();
                        res[0]++;
                    }
                }
            }

        }
        res[1] = stackOk.size();
        res[2] = stackRi.size();
        return res;
    }

}

