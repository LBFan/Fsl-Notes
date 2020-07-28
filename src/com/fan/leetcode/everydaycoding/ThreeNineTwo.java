package com.fan.leetcode.everydaycoding;

/**
 * @author : PF_23
 * @Description : 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * @date : 2020/07/27.
 */

public class ThreeNineTwo {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        // 不断indexOf,如果结果小于0，则返回false
        for (int i = 0; i < s.length(); i++) {
            int index = t.indexOf(s.charAt(i));
            if (index < 0) {
                return false;
            }
            t = t.substring(index + 1);
        }
        return true;
    }
}

