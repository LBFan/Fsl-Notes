package com.fan.leetcode.graphs.mergesearch;

/**
 * @author :  PF_23
 * @Description : 冗余连接
 * 题目描述：有一系列的边连成的图，找出一条边，移除它之后该图能够成为一棵树。
 * <p>
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given undirected graph will be like this:
 *   1
 *  / \
 * 2 - 3
 * @date : 2020/02/18.
 */

public class Num01 {
    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        UF uf = new UF(N);
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (uf.connect(u, v)) {
                return e;
            }
            uf.union(u, v);
        }
        return new int[]{-1, -1};
    }

    private class UF {

        private int[] id;

        UF(int N) {
            id = new int[N + 1];
            for (int i = 0; i < id.length; i++) {
                id[i] = i;
            }
        }

        void union(int u, int v) {
            int uID = find(u);
            int vID = find(v);
            if (uID == vID) {
                return;
            }
            for (int i = 0; i < id.length; i++) {
                if (id[i] == uID) {
                    id[i] = vID;
                }
            }
        }

        int find(int p) {
            return id[p];
        }

        boolean connect(int u, int v) {
            return find(u) == find(v);
        }
    }
}

