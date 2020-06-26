package com.fan.zuoalgorithm.cha04;

/**
 * @author :  PF_23
 * @Description : 数字字符串转换为字母组合的种数
 * @date : 2020/03/21.
 */

public class Num16 {
    /**
     * 暴力递归
     *
     * @param str
     * @return
     */
    public int num1(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        return process(chars, 0);
    }

    private int process(char[] chars, int i) {
        if (i == chars.length - 1) {
            return 1;
        }
        if (chars[i] == '0') {
            return 0;
        }
        int res = process(chars, i + 1);
        if (i + 1 < chars.length && (chars[i] - '0') * 10 + chars[i + 1] - '0' < 27) {
            res += process(chars, i + 2);
        }
        return res;
    }

    /**
     * 动态规划：类似斐波那契
     *
     * @param str
     * @return
     */
    public int num2(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int cur = chars[chars.length - 1] == '0' ? 0 : 1;
        int next = 1;
        int tmp;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '0') {
                next = cur;
                cur = 0;
            } else {
                tmp = cur;
                if ((chars[i] - '0') * 10 + chars[i + 1] - '0' < 27) {
                    cur += next;
                }
                next = tmp;
            }
        }
        return cur;
    }
}

