package com.fan.leetcode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :  PF_23
 * @Description : 按照字符出现次数对字符串排序
 * <p>
 * Input:
 * "tree"
 * Output:
 * "eert"
 * <p>
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * @date : 2020/02/20.
 */

public class Num03 {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyForNum = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);
        }
        List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];
        for (char key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if (frequencyBucket[frequency] == null) {
                frequencyBucket[frequency] = new ArrayList<>();
            }
            frequencyBucket[frequency].add(key);
        }
        StringBuilder str = new StringBuilder();
        for (int i = frequencyBucket.length - 1; i >= 0; i--) {
            if (frequencyBucket[i] == null) {
                continue;
            }
            for (char c :
                    frequencyBucket[i]) {
                for (int j = 0; j < i; j++) {
                    str.append(c);
                }
            }
        }
        return str.toString();
    }
}

