package com.fan.leetcode.top100.hard;

/**
 * @author : PF_23
 * @Description : 最小覆盖子串
 * @date : 2020/07/29.
 */

public class SevenSix {
    /**
     * 滑动窗口
     *
     * @param s s串
     * @param t t串
     * @return 最小长度
     */
    public static String minWindow(String s, String t) {
        //由于字符类型，就考虑所有的ASCII码，因此直接用128个长度的数组代替原来的HashMap,提高性能
        //用来统计t中每个字符出现次数
        int[] needs = new int[128];
        //用来统计滑动窗口中每个字符出现次数
        int[] win = new int[128];
        //统计t中每个字符出现次数
        int count = 0;
        for (char c : t.toCharArray()) {
            needs[c]++;
        }

        int l = 0, r = 0;
        int begin = 0;
        int minLen = s.length() + 1;
        int tLen = t.length();
        while (r < s.length()) {
            char ch = s.charAt(r);
            //统计滑动窗口中每个字符出现次数
            win[ch]++;
            // 当这个字符是在t中，并且t需要的次数大于等于该字符在滑动窗口出现的次数，被确定为候选字符。
            if (needs[ch] > 0 && needs[ch] >= win[ch]) {
                count++;
            }
            //当候选字符数等于t的长度时，说明滑动窗口中的字符串包含T，开始移动l，缩小窗口
            //直到不满足count == plength时，继续扩展窗口
            while (count == tLen) {
                ch = s.charAt(l);
                if (needs[ch] > 0 && needs[ch] >= win[ch]) {
                    // 到这里时needs[ch]只会 <= win[ch], 不可能是needs[ch] > win[ch]
                    count--;
                }
                //找出长度最短符合条件的结果 (r-l)+1计算当前窗口大小
                if ((r - l) + 1 < minLen) {
                    minLen = (r - l) + 1;
                    begin = l;
                }
                win[l]--;
                l++;
            }
            // 向右滑动右边界
            r++;
        }
        if (minLen == s.length() + 1) {
            return "";
        }
        return s.substring(begin, begin + minLen);
    }
}

