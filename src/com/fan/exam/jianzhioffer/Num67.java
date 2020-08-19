package com.fan.exam.jianzhioffer;

/**
 * @Description :把字符串转换成整数
 * @Author : shulin.fan
 * @Date : 2020/7/19
 */
public class Num67 {
    public static int strToInt(String str) {
        int ret = 0;
        if (str == null || str.length() <= 0) {
            return 0;
        }
        boolean isNegative = str.startsWith("-");
        int buddy = Integer.MAX_VALUE / 10;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-')) {
                continue;
            }
            if (c < '0' || c > '9') {
                break;
            }
            if (ret > buddy || (ret == buddy && c > '7')) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ret = ret * 10 + (c - '0');
        }
        return isNegative ? -ret : ret;
    }
}
