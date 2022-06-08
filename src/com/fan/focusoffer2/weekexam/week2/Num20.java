package com.fan.focusoffer2.weekexam.week2;

/**
 * @author : PF_23
 * @Description : 所有的回文字符串
 * @date : 2022/3/12 11:08.
 */

public class Num20 {

    public int countValid(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int count = 0;
        // 遍历，以遍历节点为中心向两边扩散
        for (int i = 0; i < s.length(); i++) {
            count += validCount(s, i, i);
            count += validCount(s, i , i + 1);
        }

        return count;
    }

    private int validCount(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() &&  (s.charAt(start) == s.charAt(end))) {
                count++;
                start--;
                end++;

        }
        return count;
    }
}

