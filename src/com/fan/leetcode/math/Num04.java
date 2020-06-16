package com.fan.leetcode.math;

/**
 * @author :  PF_23
 * @Description : 7进制
 * @date : 2020/02/25.
 */

public class Num04 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        boolean isNegative = num < 0;
        if (isNegative) {
            num = -num;
        }

        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        String res = sb.toString();
        return isNegative ? "-" + res : res;
    }

    /**
     * Java 中 static String toString(int num, int radix) 可以将一个整数转换为 radix 进制表示的字符串。
     *
     * @param num
     * @return
     */
    public String convertToBase7ByJavaApi(int num) {
        return Integer.toString(num, 7);
    }
}

