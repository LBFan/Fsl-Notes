package com.fan.meituan2020;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Description :表达式求值
 * @Author : shulin.fan
 * @Date : 2020/8/19
 */
public class Num01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        String[] strArr = expression.split(" ");
        //Stack<String> stack = new Stack<>();
        if (!(strArr[0].equals("true") || strArr[0].equals("false"))) {
            System.out.println("error");
            return;
        } else {
            if ((strArr.length & 1) == 1) {
                System.out.println("error");
            } else {
                for (int i = 1; i < strArr.length - 1; i += 2) {
                    // 处理and
                    if (strArr[i].equals("and")) {
                        if (strArr[i - 1].equals("false") || strArr[i + 1].equals("false")) {
                            strArr[i - 1] = strArr[i + 1] = "false";
                        }
                    }
                }

                for (int i = 0; i < strArr.length; i += 2) {
                    if (strArr[i].equals("true")) {
                        System.out.println("true");
                        return;
                    }
                }
                System.out.println("false");
            }
        }
    }
}
