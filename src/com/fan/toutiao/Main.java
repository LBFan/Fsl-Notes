package com.fan.toutiao;

import java.util.Scanner;

/**
 * @Description : 一面 ：对称二叉树
 * 二面 ： 两个52进制字符串相加 没写出来 挂 多进制相加 可以稍作修改
 * @Author : shulin.fan
 * @Date : 2020/9/6
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        System.out.println(addString(str1, str2));
    }

    private static char[] dic = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static int N = 62;

    private static String addString(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            char I = i >= 0 ? num1.charAt(i) : 0;
            char J = j >= 0 ? num2.charAt(j) : 0;
            if (I - 'a' >= 0 && I - 'a' < 26) {
                sum += i >= 0 ? I - 'a' + 10 : 0;
            } else if (I - 'A' >= 0 && I - 'A' < 26) {
                sum += i >= 0 ? I - 'A' + 36 : 0;
            } else {
                sum += i >= 0 ? I - '0' : 0;
            }
            if (J - 'a' >= 0 && J - 'a' < 26) {
                sum += j >= 0 ? J - 'a' + 10 : 0;
            } else if (J - 'A' >= 0 && J - 'A' < 26) {
                sum += j >= 0 ? J - 'A' + 36 : 0;
            } else {
                sum += j >= 0 ? J - '0' : 0;
            }

            sb.append(dic[sum % N]);
            carry = sum / N;
        }
        if (carry == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }

}
