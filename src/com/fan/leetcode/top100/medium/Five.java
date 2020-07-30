package com.fan.leetcode.top100.medium;

/**
 * @author : PF_23
 * @Description : 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * @date : 2020/07/29.
 */

public class Five {

    /**
     * 暴力法
     *
     * @param s 字符串
     * @return 最长回文子串
     */
    public static String longestPalindrome01(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // 非必须
        char[] chars = s.toCharArray();

        // 枚举所有长度严格大于1的子串chars[i..j]
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (j - i + 1 > maxLen && validPalindromic(chars, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 验证是否是回文串
     *
     * @param chars 字符数组
     * @param left  起始
     * @param right 终止
     * @return 是回文串？true ：false
     */
    private static boolean validPalindromic(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // ======================================================================= //

    /**
     * 中心扩展算法
     *
     * @param s 字符串
     * @return 最长回文子串
     */
    public static String longestPalindrome02(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < length - 1; i++) {
            int oddLength = expendAroundCenter(chars, i, i);
            int evenLength = expendAroundCenter(chars, i, i + 1);

            int curMaxLen = Math.max(oddLength, evenLength);
            if (curMaxLen > maxLen) {
                maxLen = curMaxLen;
                // 这一步在纸上画出
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * @param chars 字符数组
     * @param left  起始位置
     * @param right 终止位置
     * @return 回文串的长度
     */
    private static int expendAroundCenter(char[] chars, int left, int right) {
        // 当left== right时，回文中心是一个字符，回文串的长度是奇数
        // 当left + 1 == right时，此时回文串中心是两个字符，回文串的长度是偶数
        int len = chars.length;
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (chars[i] == chars[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 跳出while循环时，恰好满足s.charAt(i) != s.charAt(j)
        // 回文串的长度为 j - 1 - (i + 1) + 1 = j - i - 1
        return j - i - 1;
    }

    // ======================================================================= //

    /**
     * DP算法
     *
     * @param s 字符串
     * @return 最长回文子串
     */
    public static String longestPalindrome03(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j]表示s[i..j]是否为回文串
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();
        // 注意：左下角先填，并且一列一列的填写
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要dp[i][j] == true,就表示子串s[i..j]是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}

