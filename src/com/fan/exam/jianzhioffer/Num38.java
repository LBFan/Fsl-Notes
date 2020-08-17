package com.fan.exam.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description : TODO 字符串的排列
 * @Author : shulin.fan
 * @Date : 2020/7/16
 */
public class Num38 {
    private static ArrayList<String> ret = new ArrayList<>();

    public static ArrayList<String> Permutation(String str) {
        if (str == null || str.length() <= 0) {
            return new ArrayList<>();
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        boolean[] hasUsed = new boolean[chars.length];
        for (int i = 0; i < chars.length; i++) {
            backtracking(chars, hasUsed, new StringBuilder());
        }
        return ret;
    }

    private static void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
        if (chars.length == s.length()) {
            ret.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i]) {
                continue;
            }
            if (i != 0 && chars[i] == chars[i - 1] && hasUsed[i - 1]) {
                /* 保证不重复 */
                continue;
            }
            s.append(chars[i]);
            hasUsed[i] = true;
            backtracking(chars, hasUsed, s);
            // 回溯上一个字符
            s.deleteCharAt(s.length() - 1);
            hasUsed[i] = false;
        }
    }


    // =================================================================================

    List<String> rr = new ArrayList<>();
    char[] chars;

    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        chars = s.toCharArray();
        permute(0);
        return rr.toArray(new String[rr.size()]);
    }

    private void permute(int index) {
        if (index == chars.length - 1) {
            rr.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            boolean flag = false;
            for (int j = index; j < i; j++) {
                if (chars[j] == chars[i]) {
                    flag = true;
                    break;
                }
            }
            // 重复就跳过
            if (flag) {
                continue;
            }
            // 重点理解这个过程
            swap(chars, index, i);
            permute(index + 1);
            swap(chars, index, i);
        }
    }

    private void swap(char[] s, int start, int end) {
        char tmp = s[start];
        s[start] = s[end];
        s[end] = tmp;
    }
}
