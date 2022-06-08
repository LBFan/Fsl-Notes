package com.fan.focusoffer2.weekexam.week2;

/**
 * @author : PF_23
 * @Description : 最多删除一个字符得到回文
 * @date : 2022/3/12 11:02.
 */

public class Num19 {

    public boolean canGet(String s) {
        if (s.length() == 0) {
            return false;
        }

        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start++;
            end--;
        }

        return start == s.length() / 2 || isValid(s, start + 1, end) || isValid(s, start, end - 1);
    }

    private boolean isValid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i++;
            j--;
        }
        return i >= j;
    }
}

