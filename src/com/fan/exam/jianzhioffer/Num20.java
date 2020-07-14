package com.fan.exam.jianzhioffer;

/**
 * @Description : 表示数值的字符串
 * [] : 字符集合
 * () : 分组
 * ? : 重复 0 ~ 1 次 + : 重复 1 ~ n 次 * : 重复 0 ~ n 次 . :任意字符
 * \\. : 转义后的 .
 * \\d : 数字
 * @Author : shulin.fan
 * @Date : 2020/7/14
 */
public class Num20 {
    public static boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        return new String(str).matches("[+-]?\\d*(\\d.\\d+)?([eE][+-]?\\d+)?");
    }

    public static void main(String[] args) {
        char[] str = {'+', '2', '.', '3', 'e', '-', '3'};
        boolean numeric = isNumeric(str);
        System.out.println(numeric);
    }
}
