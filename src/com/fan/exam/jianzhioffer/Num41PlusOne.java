package com.fan.exam.jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description : 字符流中第一个不重复的字符
 * 思路： 双端队列解决  （哈希备用）
 * @Author : shulin.fan
 * @Date : 2020/7/17
 */
public class Num41PlusOne {
    private static char[] cnts = new char[256];

    private static Queue<Character> queue = new LinkedList<>();

    private static void insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1) {
            queue.poll();
        }
    }

    public static char firstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }

    /**
     * 100%
     *
     * @param s
     * @return
     */
    public static char firstChar(String s) {
        if (s == null || s.length() <= 0) {
            return ' ';
        }

        int[] counts = new int[256];
        for (char ch : s.toCharArray()) {
            counts[ch]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (counts[s.charAt(i)] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

}
