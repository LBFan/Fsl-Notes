package com.fan.exam.jianzhioffer;

/**
 * @Description : 正则表达式匹配
 * @Author : shulin.fan
 * @Date : 2020/7/14
 */
public class Num19 {
    /**
     * DP
     *
     * @param str     字符串
     * @param pattern 匹配串
     * @return 匹配 true else false
     */
    public boolean match(char[] str, char[] pattern) {
        int m = str.length;
        int n = pattern.length;

        boolean[][] f = new boolean[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    if (pattern[j - 1] != '*') {
                        // 字符匹配 or .
                        if (i > 0 && (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        // pattern[j - 1] == '*'
                        if (j > 1) {
                            // 不看：直接抛弃匹配串的最后两个字符
                            f[i][j] |= f[i][j - 2];
                        }
                        // 看
                        if (i > 0 && j > 1 && (str[i - 1] == pattern[j - 2] || pattern[j - 2] == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[m][n];
    }

    /**
     * 递归
     *
     * @param str     字符串
     * @param pattern 匹配串
     * @return 匹配 true else false
     */
    public boolean matchRec(String str, String pattern) {
        if (str.length() == 0) {
            if (pattern.length() == 0) {
                return true;
            }
            int i = 1;
            while (i < pattern.length()) {
                if (pattern.charAt(i) != '*') {
                    return false;
                }
                i += 2;
            }
            return true;
        }

        // str.length != 0
        if (pattern.length() == 0) {
            return false;
        }

        // c1 和 c2 分别是两个串的当前位，c3是正则串当前位的后一位，如果存在的话，就更新一下
        char c1 = str.charAt(0), c2 = pattern.charAt(0), c3 = 'a';
        if (pattern.length() > 1) {
            c3 = pattern.charAt(1);
        }

        // 和dp一样，后一位分为是 '*' 和不是 '*' 两种情况
        if (c3 != '*') {
            if (c1 == c2 || c2 == '.') {
                return matchRec(str.substring(1), pattern.substring(1));
            } else {
                // 不匹配
                return false;
            }
        } else {
            // 如果该位字符一样，或是正则串该位是 '.'，和dp一样，有看和不看两种情况
            if (c1 == c2 || c2 == '.') {
                // 匹配多次str.substring(1), pattern 或者 0次 str, pattern.substring(2))
                return matchRec(str.substring(1), pattern) || matchRec(str, pattern.substring(2));
            } else {
                // 不一样，那么正则串这两位就废了，直接往后走
                return matchRec(str, pattern.substring(2));
            }
        }
    }

}
