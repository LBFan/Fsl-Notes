package com.fan.ccb;

import java.util.Scanner;

/**
 * @Description : AC
 * @Author : shulin.fan
 * @Date : 2020/9/12
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String res = str.replaceAll("coc", "");
        System.out.println(res);
    }
}
