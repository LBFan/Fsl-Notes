package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 把字符串转换成整数
 * 将一个字符串转换成一个整数，字符串不是一个合法的数值则返回 0，要求不能使用字符串转换整数的库函数。
 * Iuput:
 * +2147483647
 * 1a33
 * Output:
 * 2147483647
 * 0
 * @date : 2019/12/31.
 */

public class Num67 {
    public int StrToInt(String str) {
//        if (str == null || str.length() == 0) {
//            return 0;
//        }
//        boolean isNegative = str.startsWith("-");
//        int ret = 0;
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if (i == 0 && (c == '+' || c == '-')) {
//                // 符号判断
//                continue;
//            }
//            if (c < '0' && c > '9') {
//                // 非法输入，直接返回0
//                return 0;
//            }
//            ret = ret * 10 + (c - '0');
//        }
//        return isNegative ? -ret : ret;

        if (str == null || str.length() == 0) {
            return 0;
        }
        int i = 0;
        long ans = 0;
        boolean isFu = false;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++; //过滤空格
        }
        //正负号
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            if (str.charAt(i) == '-') {
                isFu = true;
            }
            i++;
        }
        for (; i < str.length() && Character.isDigit(str.charAt(i)); i++) {

            ans = ans * 10 + str.charAt(i) - '0';

            long temp_ans = isFu ? -ans : ans;

            if (temp_ans <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (temp_ans >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

        }
        return (int) (isFu ? -ans : ans);
    }
}

