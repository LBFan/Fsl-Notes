package com.fan.focusoffer2.weekexam.week7;

import java.util.List;

/**
 * @author : PF_23
 * @Description : 替换单词
 * @date : 2022/4/16 10:43.
 */

public class Num63 {

    // 思路：先建立前缀树，然后遍历每一个单词，如果startwith则替换

    public String replaceWords(List<String> dict, String sentence) {
        // 构造dict的前缀树

        TrieNode root = buildTrie(dict);

        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            String prefix = searchPrefix(root, strings[i]);
            if (!prefix.isEmpty()) {
                strings[i] = prefix;
            }
        }

        return String.join(" ", strings);
    }

    private String searchPrefix(TrieNode root, String string) {
        TrieNode node = root;
        StringBuilder builder = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                // 两种情况退出循环：前缀树走到当前前缀的最后一个节点 或者 不是前缀
                break;
            }
            builder.append(c);
            node = node.children[c - 'a'];
        }

        return node.isEnd ? builder.toString() : "";
    }

    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode();
        for (String s : dict) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }
        return root;
    }

}

