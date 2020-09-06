package com.fan.leetcode.strings;

import java.util.Scanner;

/**
 * @author :  PF_23
 * @Description : 字符串循环移位包含
 * <p>
 * s1 = AABCD, s2 = CDAA
 * Return : true
 * <p>
 * 给定两个字符串 s1 和 s2，要求判定 s2 是否能够被 s1 做循环移位得到的字符串包含。
 * s1 进行循环移位的结果是 s1s1 的子字符串，因此只要判断 s2 是否是 s1s1 的子字符串即可。
 * @date : 2020/02/19.
 */

public class Num01 {
    private static boolean isContains(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() < s2.length()) {
            return false;
        }
        return s1.concat(s1).contains(s2);
    }
}

