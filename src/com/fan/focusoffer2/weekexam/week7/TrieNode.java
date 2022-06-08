package com.fan.focusoffer2.weekexam.week7;

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2022/4/16 10:47.
 */

public class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
    }

    TrieNode root;
}

