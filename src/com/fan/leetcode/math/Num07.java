package com.fan.leetcode.math;

/**
 * @author :  PF_23
 * @Description : 字符串加法
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * @date : 2020/02/25.
 */

public class Num07 {
    public String addStrings(String num1, String num2) {
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        StringBuffer sb = new StringBuffer();
        while (carry == 1 || i >= 0 || j >= 0) {
            int x = i < 0 ? 0 : num1.charAt(i--) - '0';
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}

