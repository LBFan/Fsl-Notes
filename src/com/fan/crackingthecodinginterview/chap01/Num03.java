package com.fan.crackingthecodinginterview.chap01;

/**
 * @Description : 空格替换
 * @Author : shulin.fan
 * @Date : 2020/6/9
 */
public class Num03 {

    public static String replaceSpaces(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int p1 = str.length() - 1;
        StringBuilder stringBuilder = new StringBuilder(str);
        for (int i = 0; i <= p1; i++) {
            if (str.charAt(i) == ' ') {
                stringBuilder.append("  ");
            }
        }

        int p2 = stringBuilder.length() - 1;

        while (p1 >= 0 && p2 > p1) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                stringBuilder.setCharAt(p2--, '0');
                stringBuilder.setCharAt(p2--, '2');
                stringBuilder.setCharAt(p2--, '%');
            } else {
                stringBuilder.setCharAt(p2--, c);
            }
        }

        return stringBuilder.toString();

    }

}
