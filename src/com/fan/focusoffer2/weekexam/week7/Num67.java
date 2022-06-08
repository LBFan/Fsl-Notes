package com.fan.focusoffer2.weekexam.week7;

/**
 * @author : PF_23
 * @Description : 最大的异或
 * @date : 2022/4/16 12:07.
 */

public class Num67 {

    public static class TrieNode {
        TrieNode[] children;

        public TrieNode() {
            // 0, 1
            children = new TrieNode[2];
        }
    }


    private TrieNode buildTrie(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                // 当前为num是0或者1
                int bit = (num >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }
        return root;
    }

    public int maxXOR(int[] nums) {
        TrieNode root = buildTrie(nums);
        int max = 0;
        for (int num : nums) {
            TrieNode node = root;
            int xor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = num >> i & 1;
                if (node.children[1 - bit] != null) {
                    xor = (max << 1) + 1;
                    node = node.children[1 - bit];
                } else {
                    xor <<= 1;
                    node = node.children[bit];
                }
            }
            max = Math.max(max, xor);
        }
        return max;
    }
}

