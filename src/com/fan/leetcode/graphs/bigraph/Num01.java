package com.fan.leetcode.graphs.bigraph;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 判断是否为二分图
 * @date : 2020/02/18.
 */

public class Num01 {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1 && !isBipartite(i, 0, colors, graph)) {
                return false;
            }
        }
        return true;
    }

    private boolean isBipartite(int curNode, int curColor, int[] colors, int[][] graph) {
        if (colors[curNode] != -1) {
            return colors[curNode] == curColor;
        }
        colors[curNode] = curColor;
        for (int nextNode : graph[curNode]) {
            if (!isBipartite(nextNode, 1 - curColor, colors, graph)) {
                return false;
            }
        }
        return true;
    }
}

