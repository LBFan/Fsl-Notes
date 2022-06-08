package com.fan.focusoffer2.weekexam.week2;

import java.util.Map;

/**
 * @author : PF_23
 * @Description : 不含重复字符的最长子字符串
 * @date : 2022/3/12 10:27.
 */

public class Num16 {

    /**
     * 需要多次遍历哈希表
     * @param s
     * @return
     */
    public int maxLenSubStr(String s) {
        // 考虑边界
        if (s.length() == 0) {
            return 0;
        }
        // 理清思路，还是用一个哈希表将每一个字符出现的次数记录下来，如果 一个子字符串不含重复的字符=，那么哈希表中的每一个值都不会大于1
        // 使用双指针移动
        int[] counts = new int[256];
        int i = 0;
        // 代表当前子字符串的左下标前一个位置
        int j = -1;
        int maxLen = -1;

        for (; i < s.length(); i++) {
            counts[s.charAt(i)]++;
            while (generateThanOne(counts)) {
                j++;
                counts[s.charAt(j)]--;
            }

            maxLen = Math.max(maxLen, i - j);
        }

        return maxLen;
    }

    private boolean generateThanOne(int[] counts) {
        for (int c : counts) {
            if (c > 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 改进：不需要多次遍历哈希表，只要出现了次数大于1的，就使用一个变量记录下来，只有当变量值为0的时候，表示当前连续子字符串才没有重复字符
     * @param s
     * @return
     */
    public int maxLenSubStr2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] counts = new int[256];
        int i = 0;
        int j = -1;
        // 记录当前子字符串是否包含重复字符，包含就加1
        int countTmp = 0;
        int maxLen = -1;
        for (; i < s.length(); i++) {
            counts[s.charAt(i)]++;
            if (counts[s.charAt(i)] == 2) {
                countTmp++;
            }

            while (countTmp > 0) {
                // 去重过程：深度思考
                j++;
                counts[s.charAt(j)]--;
                if (counts[s.charAt(j)] == 1) {
                    // 说明s.charAt(j)之前有重复
                    countTmp--;
                }
            }

            maxLen = Math.max(maxLen, i - j);
        }
        return maxLen;

    }
}

