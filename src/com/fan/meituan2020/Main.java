package com.fan.meituan2020;

import java.util.Scanner;

/**
 * @Description : 小美的用户名 AC
 * 题目描述：
 * 小美是美团的前端工程师，为了防止系统被恶意攻击，小美必须要在用户输入用户名之前做一个合法性检查，一个合法的用户名必须满足以下几个要求：
 *
 * 1.    用户名的首字符必须是大写或者小写字母。
 *
 * 2.    用户名只能包含大小写字母，数字。
 *
 * 3.    用户名需要包含至少一个字母和一个数字。
 *
 * 如果用户名合法，请输出“Accept”，反之输出“Wrong”。
 *
 *
 *
 * 输入描述
 * 输入第一行包含一个正整数T，表示需要检验的用户名数量。(1<=T<=100)
 *
 * 接下来有T行，每行一个不超过20的字符串s，表示输入的用户名。
 *
 * 输出描述
 * 对于每一个输入的用户名s，请输出一行，即按题目要求输出一个字符串。
 *
 *
 * 样例输入
 * 5
 * Ooook
 * Hhhh666
 * ABCD
 * Meituan
 * 6666
 * 样例输出
 * Wrong
 * Accept
 * Wrong
 * Wrong
 * Wrong
 * @Author : shulin.fan
 * @Date : 2020/8/22
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 0) {
            String[] names = new String[n];
            for (int i = 0; i < n; i++) {
                names[i] = sc.next();
            }

            boolean[] accept = isAccept(names);
            for (int i = 0; i < n; i++) {
                String res = accept[i] ? "Accept" : "Wrong";
                System.out.println(res);
            }
        }
    }

    private static boolean[] isAccept(String[] names) {
        int n = names.length;
        boolean[] res = new boolean[n];
        for (int i = 0; i < n; i++) {
            String name = names[i];
            if (name.length() < 2) {
                continue;
            }
            char first = name.charAt(0);
            if ((first >= 'A' && first <= 'Z') || (first >= 'a' && first <= 'z')) {
                int len = name.length();
                int index = 1;
                while (index < len) {
                    char ch = name.charAt(index);
                    if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                        if (ch >= '0' && ch <= '9') {
                            res[i] = true;
                        }
                    } else {
                        res[i] = false;
                        break;
                    }
                    index++;
                }
            }
        }
        return res;
    }
}
