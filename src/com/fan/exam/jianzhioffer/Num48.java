package com.fan.exam.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 最长不含重复字符的字符串
 * @Author : shulin.fan
 * @Date : 2020/7/17
 */
public class Num48 {
    public static int longestSubStringWithoutDuplication(String str) {
        //int curLen = 0;
        //int maxLen = 0;
        //
        //int[] position = new int[128];
        //for (int i = 0; i < str.length(); i++) {
        //    position[i] = -1;
        //}
        //
        //for (int i = 0; i < str.length(); i++) {
        //    int prevIndex = position[str.charAt(i) - ' '];
        //    if (prevIndex < 0 || i - prevIndex > curLen) {
        //        ++curLen;
        //    } else {
        //        if (curLen > maxLen) {
        //            maxLen = curLen;
        //        }
        //        curLen = i - prevIndex;
        //    }
        //    position[str.charAt(i) - ' '] = i;
        //}
        //
        ///return Math.max(maxLen, curLen);

        Map<Character, Integer> dic = new HashMap<>();
        int res = 0;
        int tmp = 0;
        for (int i = 0; i < str.length(); i++) {
            int j = dic.getOrDefault(str.charAt(i), -1);
            dic.put(str.charAt(i), i);
            tmp = tmp < i - j ? tmp + 1 : i - j;
            res = Math.max(res, tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "aasdfgsdf";
        int i = longestSubStringWithoutDuplication(str);
        System.out.println(i);
    }
}
