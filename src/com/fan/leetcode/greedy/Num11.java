package com.fan.leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description : 分隔字符串使同种字符出现在一起
 * <p>
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。
 * 返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例 1:
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * @date : 2020/01/16.
 */

public class Num11 {
    public List<Integer> partitionLabels(String S) {
//        int[] lastIndexsOfChar = new int[26];
//        for (int i = 0; i < S.length(); i++) {
//            lastIndexsOfChar[char2Index(S.charAt(i))] = i;
//        }
//        List<Integer> partitions = new ArrayList<>();
//        int firstIndex = 0;
//        while (firstIndex < S.length()) {
//            int lastIndex = firstIndex;
//            for (int i = firstIndex; i < S.length() && i <= lastIndex; i++) {
//                int index = lastIndexsOfChar[char2Index(S.charAt(i))];
//                if (index > lastIndex) {
//                    lastIndex = index;
//                }
//            }
//            partitions.add(lastIndex - firstIndex + 1);
//            firstIndex = lastIndex + 1;
//        }
//        return partitions;

        List<Integer> ret = new ArrayList<>();
        int len = S.length();
        char[] cs = S.toCharArray();

        int[] chars = new int[26];
        for (int i = 0; i < len; i++) {
            chars[cs[i] - 'a'] = i;
        }

        int left = 0, last = 0;
        while (left < len) {
            for (int i = left; i < len && i <= last; i++) {
                last = Math.max(last, chars[cs[i] - 'a']);
            }
            ret.add(last - left + 1);
            left = last + 1;
            last++;
        }
        return ret;
    }

    private int char2Index(char c) {
        return c - 'a';
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> partitionLabels = new Num11().partitionLabels(s);
        System.out.println(partitionLabels.toString());
    }
}

