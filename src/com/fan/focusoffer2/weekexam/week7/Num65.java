package com.fan.focusoffer2.weekexam.week7;

/**
 * @author : PF_23
 * @Description : 最短的单词编码
 * @date : 2022/4/16 11:09.
 */

public class Num65 {

    //思路：先求出所有单词的长度，加上n,就是最大长度，反序每一个单词，构造前缀树，然后遍历所有单词，如果是前缀就减去单词长度再减一

    public int minLen(String[] words) {
        int min = 0;
        for (String word : words) {
            min += word.length() + 1;
        }

        // 反序构造前缀树
        TrieNode root = buildTrie(words);

        // 遍历
        for (String word : words) {
            if (searchPrefix(root, word)) {
                min -= word.length() - 1;
            }
        }

        return min;
    }

    private boolean searchPrefix(TrieNode root, String word) {
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (node.children[chars[i] - 'a'] == null) {
                return false;
            }
            node = node.children[chars[i] - 'a'];
        }

        return !node.isEnd;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            char[] chars = word.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                // 构造过程中如果中途有潜质，就将中途的前缀isEnd置为false

                if (node.isEnd) {
                    node.isEnd = false;
                }

                if (node.children[chars[i] - 'a'] == null) {
                    node.children[chars[i] - 'a'] = new TrieNode();
                }
                node = node.children[chars[i] - 'a'];
            }

            node.isEnd = true;
        }

        return root;
    }
}

