package com.fan.focusoffer2.weekexam.week2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : PF_23
 * @Description : 含有所有字符的最短字符串:返回 s 中包含 t 的所有字符的最短子字符串,不存在则返回""
 * @date : 2022/3/12 10:47.
 */

public class Num17 {

    /**
     * 使用一个count来表示目前是否s的子字符串已经包含t:如果包含则count = 0， 反之count > 0
     * @param s
     * @param t
     * @return
     */
    public String minSubStr(String s, String t) {

        Map<Character, Integer> charToCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            charToCount.put(c, charToCount.getOrDefault(c ,0) + 1);
        }

        // 表示的是
        int count = charToCount.size();

        int start = 0, end = 0;
        int minLe = -1, minRi = -1;
        int minLen = Integer.MAX_VALUE;

        while (end  < s.length() || (count == 0 && s.length() == end)) {
            if (count > 0) {
                // s还没有包含完t, 向右移动指针
                if (charToCount.containsKey(s.charAt(end))) {
                    charToCount.put(s.charAt(end), charToCount.get(s.charAt(end)) - 1);
                    if (charToCount.get(s.charAt(end)) == 0) {
                        count--;
                    }
                }
                end++;
            } else {
                // count == 0
                if (end -start < minLen) {
                    minLen = end - start;
                    minLe = start;
                    minRi = end;
                }
                // 向右移动左指针
                if (charToCount.containsKey(s.charAt(start))) {
                    charToCount.put(s.charAt(start), charToCount.get(s.charAt(start)) + 1);
                    if (charToCount.get(s.charAt(start)) == 1) {
                        count++;
                    }
                }
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLe, minRi);

    }

    /**
     * 滑动窗口
     * @param s
     * @param t
     * @return
     */
    public String minLenStr(String s, String t)  {
        // 将所有的出现的字符都记录下来
        int[] counts = new int[256];
        for (char c : t.toCharArray()) {
            counts[c]++;
        }

        int start = 0, end = 0;
        int minStart = -1, minEnd = -1;
        int minLen = Integer.MAX_VALUE;

        counts[s.charAt(end)]--;
        while ((start <= end && end < s.length())){
            if (!isLetterThanZero(counts)) {
                end++;
                // 说明现在s还没有包含完t，需要向右移动指针
                if (end < s.length()) {
                    counts[s.charAt(end)]--;
                }
            } else {
                if (end - start < minLen) {
                    minStart = start;
                    minEnd = end;
                    minLen = end - start;
                }
                // 先把start的counts值加1，向右移动左指针
                counts[s.charAt(start)]++;
                start++;
            }
        }

        return minStart == -1 ? "" : s.substring(minStart, minEnd + 1);

    }

    private boolean isLetterThanZero(int[] counts) {
        for (int count : counts) {
            if (count > 0) {
                return false;
            }
        }
        return true;
    }


}

