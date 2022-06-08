package com.fan.focusoffer2.weekexam.week2;

import java.util.ArrayList;
import java.util.List;

import static com.fan.focusoffer2.Num14.areAllZero;

/**
 * @author : PF_23
 * @Description : 字符串中的所有变位词
 * @date : 2022/3/12 10:17.
 */

public class Num15 {

    /**
     * 思路和14题一样
     * @param s1
     * @param s2
     * @return
     */
    public List<Integer> allPivot(String s1, String s2) {
        List<Integer> res = new ArrayList<>();
        if (s2.length() < s1.length()) {
            return res;
        }


        int[] sumCount = new int[26];
        int i = 0;
        for (; i < s1.length(); i++) {
            sumCount[s1.charAt(i) -'a']++;
            sumCount[s2.charAt(i) - 'a']--;
        }

        if (areAllZero(sumCount)) {
            res.add(0);
        }

        for (int j = i; j < s2.length(); j++) {
            sumCount[s2.charAt(j - s1.length()) - 'a']++;
            sumCount[s2.charAt(j) - 'a']--;
            if (areAllZero(sumCount)) {
                res.add(j - s1.length());
            }
        }
        return res;
    }
}

