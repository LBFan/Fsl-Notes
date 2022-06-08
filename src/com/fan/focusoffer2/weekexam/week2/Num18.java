package com.fan.focusoffer2.weekexam.week2;

/**
 * @author : PF_23
 * @Description : 有效的回文:注意大小写不敏感
 * @date : 2022/3/12 10:53.
 */

public class Num18 {

    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }

        int i = 0, j = s.length() - 1;
        while (i < j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (!isLetterOrDigit(c1)) {
                i++;
            } else

            if (!isLetterOrDigit(c2)) {
                j--;
            } else {
                if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                    return false;
                }
                i++;
                j--;
            }
        }

        return true;
    }

    private boolean isLetterOrDigit(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }
}

