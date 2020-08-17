package com.fan.leetcode.interview200;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description : 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 思路： 滑动窗口
 * @Author : shulin.fan
 * @Date : 2020/8/3
 */
public class Num03 {
    public static int lengthOfLongestSubstring(String s) {
        //// set
        //Set<Character> set = new HashSet<>();
        //int n = s.length();
        //// 右边界初始为-1， 最长长度初始为0
        //int rk = -1, ans = 0;
        //
        //for (int i = 0; i < n; i++) {
        //    if (i != 0) {
        //        // 移除左边字符
        //        set.remove(s.charAt(i));
        //    }
        //    while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
        //        set.add(s.charAt(rk + 1));
        //        rk++;
        //    }
        //    ans = Math.max(ans, rk - i + 1);
        //}

        int ans = 0, n = s.length();
        int[] index = new int[128];
        for (int i = 0, j = 0; j < n; ++j) {
            i = Math.max(i, index[s.charAt(j)]);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int lengthOfLongestSubstring = lengthOfLongestSubstring(s);
        System.out.println(lengthOfLongestSubstring);
    }
}
