package com.fan.focusoffer2.weekexam.week7;

/**
 * @author : PF_23
 * @Description : 实现前缀树
 * @date : 2022/4/16 10:28.
 */

public class Num62 {

    /**
     * 插入单词到前缀树中
     *
     * @param word
     */
    public void insert(String word) {
        TrieNode root = new TrieNode();
        for (char c : word.toCharArray()) {
            if (root.children[c - 'a'] == null) {
                root.children[c - 'a'] = new TrieNode();
            }
            root = root.children[c - 'a'];
        }
        root.isEnd = true;

    }

    /**
     * 是否存在word单词
     *
     * @param word
     * @return
     */
    public boolean search(String word) {
        TrieNode root = new TrieNode();
        for (char c : word.toCharArray()) {
            if (root.children[c - 'a'] == null) {
                return false;
            }
            root = root.children[c - 'a'];
        }
        return root.isEnd;
    }

    /**
     * 是否存在以word开头的单词
     *
     * @param word
     * @return
     */
    public boolean searchPrefix(String word) {
        TrieNode root = new TrieNode();
        for (char c : word.toCharArray()) {
            if (root.children[c - 'a'] == null) {
                return false;
            }
            root = root.children[c - 'a'];
        }
        return true;
    }
}

