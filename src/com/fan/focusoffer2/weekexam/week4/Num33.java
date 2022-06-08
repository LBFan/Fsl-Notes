package com.fan.focusoffer2.weekexam.week4;

import java.util.*;

/**
 * @author : PF_23
 * @Description : 变位词组
 * @date : 2022/3/26 12:30.
 */

public class Num33 {

    public List<List<String>> getList(List<String> words) {
        // key为每一组变位词排序后的字符串，value为变位词组
        Map<String, List<String>> counts = new HashMap<>();
        // 先将所有的字符串排序，然后分组
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            // 放在map中，如果存在，则将结果加上当前的word,不存在则创建节点
            counts.putIfAbsent(sorted, new ArrayList<>());
            counts.get(sorted).add(word);
        }

        return new ArrayList<>(counts.values());
    }
}

