package com.fan.exam.jianzhioffer;

/**
 * @Description :翻转单词顺序列
 * @Author : shulin.fan
 * @Date : 2020/7/18
 */
public class Num58 {
    public String reverseSentence(String str) {
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
}
