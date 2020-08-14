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
    public static boolean isNumeric(String s) {
        /// if (str == null || str.length == 0) {
        //    return false;
        //}
        //return new String(str).matches("[+-]?\\d*(\\d.\\d+)?([eE][+-]?\\d+)?");

        // s为空对象或 s长度为0(空字符串)时, 不能表示数值
        if (s == null || s.length() == 0) {
            return false;
        }
        // 标记是否遇到数位、小数点、‘e’或'E'
        boolean isNum = false, isDot = false, isE_or_e = false;
        // 转为字符数组，遍历判断每个字符
        char[] str = s.trim().toCharArray();
        for (int i = 0; i < str.length; i++) {
            // 判断当前字符是否为 0~9 的数位
            if (str[i] >= '0' && str[i] <= '9') {
                isNum = true;
            } else if (str[i] == '.') {
                // 遇到小数点
                // 小数点之前可以没有整数，但是不能重复出现小数点、或出现‘e’、'E'
                if (isDot || isE_or_e) {
                    return false;
                }
                // 标记已经遇到小数点
                isDot = true;
            } else if (str[i] == 'e' || str[i] == 'E') {
                // 遇到‘e’或'E'
                if (!isNum || isE_or_e) {
                    // ‘e’或'E'前面必须有整数，且前面不能重复出现‘e’或'E'return false;
                    // 标记已经遇到‘e’或'E'
                    isE_or_e = true;
                }
                // 重置isNum，因为‘e’或'E'之后也必须接上整数，防止出现 123e或者123e+的非法情况
                isNum = false;
            } else if (str[i] == '-' || str[i] == '+') {
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    // 正负号只可能出现在第一个位置，或者出现在‘e’或'E'的后面一个位置
                    return false;
                }
            } else {
                // 其它情况均为不合法字符
                return false;
            }
        }
        return isNum;
    }

    public static void main(String[] args) {
        //char[] str = {'+', '2', '.', '3', 'e', '-', '3'};
        //boolean numeric = isNumeric(str);
        //System.out.println(numeric);
    }
}
