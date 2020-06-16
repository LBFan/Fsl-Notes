package com.fan.leetcode.strings;

/**
 * @author :  PF_23
 * @Description : 回文子字符串个数
 * <p>
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * <p>
 * 从字符串的某一位开始，尝试着去扩展子字符串。
 * @date : 2020/02/19.
 */

public class Num07 {
    private int cnt = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            // 奇数长度
            extendSubstrings(s, i, i);
            // 偶数长度
            extendSubstrings(s, i, i + 1);
        }
        return cnt;
    }

    private void extendSubstrings(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            cnt++;
        }
    }
}

