package com.fan;

/**
 * @author :  PF_23
 * @Description : 有多少个回文子串
 * @date : 2020/03/18.
 */

public class IsPalindromic {
    public static int countSubstrings(String s) {
//        // 遍历所有子字符串，找出其中的回文字符串
//        int count = 0;
//        // i 表示子字符串的长度
//        for (int i = 1; i <= s.length(); ++i) {
//            for (int j = 0; j < s.length(); ++j) {
//                // 首先判断子字符串的长度是否大于等于i
//                if (s.substring(j, j + i).length() >= i) {
//                    String tmp = s.substring(j, j + i);
//                    if (isPalindromic(tmp)) {
//                        count++;
//                    }
//                }
//            }
//        }
//        return count;

        int n = s.length();
        if (s == null || n == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int left;
            int right;
            if (i % 2 == 0) {
                left = right = i / 2;
            } else {
                left = i / 2;
                right = i / 2 + 1;
            }
            while (left >= 0 && right < n && str[left] == str[right]) {
                left--;
                right++;
                ans++;
            }

        }
        return ans;
    }

    private static boolean isPalindromic(String s) {
        int l = 0, h = s.length() - 1;
        while (l < h) {
            if (s.charAt(l++) != s.charAt(h--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaa";
        int countSubstrings = IsPalindromic.countSubstrings(s);
        System.out.println(countSubstrings);
    }
}

