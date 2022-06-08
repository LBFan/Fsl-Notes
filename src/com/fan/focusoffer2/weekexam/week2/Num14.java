package com.fan.focusoffer2.weekexam.week2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : PF_23
 * @Description : 变位词
 * @date : 2022/3/12 09:54.
 */

public class Num14 {

    /**
     * 前短后长：s2是否存在一个连续子字符串是s1的变位词（都出现了相同的字符，但是顺序不一样）
     * 思路：暴力解，可以解但效率很低
     * 方法：可以将s1出现的美哦一个字符都记录下来，指针向右移动一位，就讲出现的字母计数加1，同时遍历s2，如果出现了相同字符，就将该值减1，没出现的忽略，。因为不关心
     * 如果s1遍历完成后，s2也遍历到相同长度了，此时哈希表里值都为0表示是变位词，否则不是，需要使用双指针去遍历s2,直到便利完成都还没找到就返回false
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isPivot(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        // 因为说了是只有小写字母，所以可以使用一个26大小的数组代替哈希表
        int[] sumOfChar = new int[26];
        int i = 0;
        for (; i < s1.length(); i++) {
            sumOfChar[s1.charAt(i) - 'a']++;
            // 忽s2出现但是s1中没有出现的字符
            sumOfChar[s2.charAt(i) - 'a']--;
        }

        if (areAllZero(sumOfChar)) {
            return true;
        }


        for (; i < s2.length(); i++) {
            sumOfChar[s2.charAt(i) - 'a']--;
            sumOfChar[s2.charAt(i - s1.length()) - 'a']++;

            if (areAllZero(sumOfChar)) {
                return true;
            }
        }

        return false;

    }

    private boolean areAllZero(int[] sumOfChar) {
        for (int i : sumOfChar) {
            if (i != 0) {
                return false;
            }
         }
        return true;
    }
}

