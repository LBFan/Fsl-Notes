package com.fan.focusoffer2.weekexam.week4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : PF_23
 * @Description : 变为词
 * @date : 2022/3/26 12:17.
 */

public class Num32 {


    public static boolean isValid(String s, String t) {
        // 相同字符串不是变位词
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }
        //直接开写
        Map<Character, Integer> charCounts = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!charCounts.containsKey(c) || charCounts.get(c) == 0) {
                return false;
            }
            charCounts.put(c, charCounts.get(c) - 1);
        }

        return true;

    }

    public static void main(String[] args) {
        String s = "a";
        String t = "a";
        boolean valid = isValid(s, t);

        System.out.println(valid);
    }

}

