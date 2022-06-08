package com.fan.focusoffer2.weekexam.week9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : PF_23
 * @Description : 分割回文子字符串
 * @date : 2022/5/21 10:17.
 */

public class Num86 {

    public String[][] method(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, new LinkedList<>(), result);
        String[][] res = new String[result.size()][];
        return listToArray(result);
        //return result;
    }

    private void helper(String s, int start, LinkedList<String> strings, List<List<String>> result) {
        if (start == s.length()) {
            //说明分割完成
            result.add(new LinkedList<>(strings));

            //return;
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isTrue(s, start, i)) {
                    // 是回文
                    strings.add(s.substring(start, i + 1));
                    helper(s, i + 1, strings, result);
                    strings.removeLast();
                }
            }
        }
    }

    /**
     * 判断是否是回文串
     *
     * @param s
     * @param start
     * @param end
     * @return
     */
    private boolean isTrue(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 3;
        Num86 num85 = new Num86();
        String[][] googles = num85.method("GOOGLE");
        System.out.println(googles);
    }

    private String[][] listToArray(List<List<String>> lists) {
        String[][] res = new String[lists.size()][];
        for (int i = 0; i < lists.size(); i++) {
            List<String> stringList = lists.get(i);
            res[i] = new String[stringList.size()];
            for (int j = 0; j < stringList.size(); j++) {
                String s = stringList.get(j);
                res[i][j] = s;
            }
        }

        return res;
    }
}

