package com.fan.focusoffer2.weekexam.week7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : PF_23
 * @Description : 单词之和：map + 前缀树
 * @date : 2022/4/16 11:24.
 */

public class Num66 {

    private Map<String, Integer> mapCount;

    private TrieNode root;

    public Num66() {
        mapCount = new HashMap<>();
    }

    public void insert(String word, int k) {
        if (!mapCount.containsKey(word)) {
            // 构造前缀树
            buildTrie(word, k);
        }
        mapCount.put(word, k);
    }

    private void buildTrie(String word, int k) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.value = k;
    }

    public int sumOfMap(String word) {
        // 求出所有以word开头的map中的key和value
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                break;
            }
            node = node.children[c - 'a'];
        }

        return getSum(node);
    }

    private int getSum(TrieNode node) {
        if (node == null) {
            return 0;
        }

        int result = node.value;
        for (TrieNode child : node.children) {
            result += getSum(child);
        }

        return result;
    }

    public static class TrieNode{
        TrieNode[] children;
        int value;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}

