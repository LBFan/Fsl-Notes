package com.fan.leetcode;

/**
 * @Description :
 * @Author : shulin.fan
 * @Date : 2020/8/17
 */
public class Eight {
    public String longestCommonPrefix(String[] strs) {
        // 方法一： 水平扫描
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
