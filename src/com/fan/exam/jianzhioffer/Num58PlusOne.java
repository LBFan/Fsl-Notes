package com.fan.exam.jianzhioffer;

/**
 * @Description : 左旋转字符串
 * @Author : shulin.fan
 * @Date : 2020/7/18
 */
public class Num58PlusOne {
    public String leftReverse(String str, int k) {
        if (k >= str.length()) {
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, k);
        reverse(chars, k + 1, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int l, int h) {
        while (l < h) {
            swap(chars, l++, h--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}
