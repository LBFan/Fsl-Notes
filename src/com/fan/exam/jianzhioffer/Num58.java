package com.fan.exam.jianzhioffer;

/**
 * @Description :翻转单词顺序列
 * 正确的解法应该是先旋转每个单词，再旋转整个字符串。
 * @Author : shulin.fan
 * @Date : 2020/7/18
 */
public class Num58 {
    public String reverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        ///int n = str.length();
        //char[] chars = str.toCharArray();
        //int i = 0, j = 0;
        //
        //// 此处两个变量用来控制每个字符串的起始位置和终止位置
        //while (j <= n) {
        //    if (j == n || chars[j] == ' ') {
        //        reverse(chars, i, j - 1);
        //        i = j + 1;
        //    }
        //    j++;
        //}
        //reverse(chars, 0, n - 1);
        //return new String(chars);
        String[] a = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = a.length - 1; i >= 0; i--) {
            if (!a[i].equals("")) {
                sb.append(a[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    private void reverse(char[] chars, int l, int h) {
        while (l < h) {
            swap(chars, l++, h--);
        }
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}
