package com.fan.exam.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 最长不含重复字符的字符串长度
 * @Author : shulin.fan
 * @Date : 2020/7/17
 */
public class Num48 {
    public static int longestSubStringWithoutDuplication(String s) {
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

//        Map<Character, Integer> dic = new HashMap<>();
//        int res = 0;
//        int tmp = 0;
//        for (int i = 0; i < str.length(); i++) {
//            int j = dic.getOrDefault(str.charAt(i), -1);
//            dic.put(str.charAt(i), i);
//            tmp = tmp < i - j ? tmp + 1 : i - j;
//            res = Math.max(res, tmp);
//        }
//        return res;
        // 滑动窗口
//        int n = s.length(), ans = 0;
//        //key出现的字符，value对应的最新的位置
//        Map<Character, Integer> map = new HashMap<>();
//        // try to extend the range [i, j]
//        for (int end = 0, start = 0; end < n; end++) {
//            if (map.containsKey(s.charAt(end))) {
//                //由于重复的坐标不知道在start的前方还是后方，所以要取个最大值
//                start = Math.max(map.get(s.charAt(end)) + 1, start);
//            }
//            ans = Math.max(ans, end - start + 1);
//            map.put(s.charAt(end), end);
        //Map<Character, Integer> dic = new HashMap<>();
        //int res = 0;
        //int tmp = 0;
        //for (int i = 0; i < str.length(); i++) {
        //    int j = dic.getOrDefault(str.charAt(i), -1);
        //    dic.put(str.charAt(i), i);
        //    tmp = tmp < i - j ? tmp + 1 : i - j;
        //    res = Math.max(res, tmp);
        //}
        //return res;

        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int i = -1;
        int res = 0;
        for (int j = 0; j < s.length(); ++j) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            map.put(s.charAt(j), j);
            res = Math.max(res, j - i);
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "pwwkew";
        int i = longestSubStringWithoutDuplication(str);
        System.out.println(i);
    }
}
