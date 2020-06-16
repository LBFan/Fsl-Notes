package com.fan.crackingthecodinginterview.chap01;

import java.util.Arrays;

/**
 * @Description :  Given two strings,write a method to decide if one is a permutation of the other.
 * @Author : shulin.fan
 * @Date : 2020/6/9
 */
public class Num02 {

    /**
     * 排序比较法
     *
     * @param s s
     * @param t t
     * @return true/false
     */
    public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    private static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /**
     * 计数统计法
     *
     * @param s s
     * @param t t
     * @return true/false
     */
    public static boolean permutation2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[128];

        char[] s_array = s.toCharArray();
        for (char c : s_array) {
            letters[c]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
