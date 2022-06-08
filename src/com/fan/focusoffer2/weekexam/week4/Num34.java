package com.fan.focusoffer2.weekexam.week4;

/**
 * @author : PF_23
 * @Description : 外星语言是否排序
 * @date : 2022/3/26 12:44.
 */

public class Num34 {

    public boolean isSorted(String[] words, String order) {
        // 先将order的排序记录下来
        int[] orderArray = new int[26];
        for (int i = 0; i < order.toCharArray().length; i++) {
            // 代表当前下标的字符出现在第几个位置
            orderArray[order.charAt(i) - 'a'] = i;
        }

        // 遍历比较当前字符串和下一个字符串
        for (int i = 0; i < words.length - 1; i++) {
            if (!isOrder(words[i], words[i + 1], orderArray)) {
                return false;
            }
        }

        return true;
    }

    // 根据排序数组判断是否排序
    private boolean isOrder(String s, String t, int[] orderArray) {
        int i = 0;
        for (; i < s.length() && i < t.length(); i++) {
            if (orderArray[s.charAt(i) - 'a'] < orderArray[t.charAt(i) - 'a']) {
                return true;
            }
            if (orderArray[s.charAt(i) - 'a'] > orderArray[t.charAt(i) - 'a']) {
                return false;
            }

        }
        return i == s.length();
    }
}

