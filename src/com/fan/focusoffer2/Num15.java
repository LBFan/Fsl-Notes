package com.fan.focusoffer2;

import java.util.ArrayList;
import java.util.List;

import static com.fan.focusoffer2.Num14.areAllZero;

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2022/3/9 23:47.
 */

public class Num15 {
    /**
     * * 字符串中的所有变位词：求出所有变位词的第一个字符出现的下标
     * * 可以说和14题几乎一样，只是返回的值不同，这里如果在遍历过程中出现了变位词，程序不结束，
     * * 只是将第一个字母出现的下标存下来，需要遍历完2字符串，找出所有的变位词首字母下标
     */

    public List<Integer> findAnagrams(String s1, String s2) {
        List<Integer> res = new ArrayList<>();
        int[] countChar = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            countChar[s2.charAt(i) - 'a']++;
            countChar[s1.charAt(i) - 'a']--;
        }

        if (areAllZero(countChar)) {
            res.add(0);
        }

        for (int i = s2.length(); i < s1.length(); i++) {
            countChar[s2.charAt(i - s1.length()) - 'a']++;
            countChar[s2.charAt(i) - 'a']--;
            if (areAllZero(countChar)) {
                res.add(i - s2.length() + 1);
            }
        }
        return res;
    }


}