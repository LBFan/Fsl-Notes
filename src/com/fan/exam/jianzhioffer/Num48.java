package com.fan.exam.jianzhioffer;

/**
 * @Description : 最长不含重复字符的字符串
 * @Author : shulin.fan
 * @Date : 2020/7/17
 */
public class Num48 {
    public static int longestSubStringWithoutDuplication(String str) {
        int curLen = 0;
        int maxLen = 0;

        int[] position = new int[26];
        for (int i = 0; i < str.length(); i++) {
            position[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            int prevIndex = position[str.charAt(i) - 'a'];
            if (prevIndex < 0 || i - prevIndex > curLen) {
                ++curLen;
            } else {
                if (curLen > maxLen) {
                    maxLen = curLen;
                }
                curLen = i - prevIndex;
            }
            position[str.charAt(i) - 'a'] = i;
        }

        return Math.max(maxLen, curLen);
    }

    public static void main(String[] args) {
        String str = "aasdfgsdf";
        int i = longestSubStringWithoutDuplication(str);
        System.out.println(i);
    }
}
