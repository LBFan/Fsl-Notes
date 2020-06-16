package com.fan.baidu;

import java.util.Scanner;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/03/29.
 */

public class Main03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = sc.nextInt();
        }
        int[][] edges = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < 2; j++) {
                edges[i][j] = sc.nextInt();
            }
        }

        int maxLenPath = maxLenPath(n, nodes, edges);
        System.out.println(maxLenPath);
    }

    /**
     * 从最大值开始找最长路径
     *
     * @param n
     * @param nodes
     * @param edges
     * @return
     */
    private static int maxLenPath(int n, int[] nodes, int[][] edges) {
        int len = 1;
        int maxLen = 0;
        // 查找每一个index对应的最长路径
        for (int k = 0; k < n; k++) {
            int t = k;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < 2; j++) {
                    if (edges[i][j] == (t + 1) && j == 0) {
                        if (nodes[t] > nodes[edges[i][1]]) {
                            len++;
                            t = edges[i][1] - 1;
                        }
                    } else if (edges[i][j] == (t + 1) && nodes[t] > nodes[edges[i][0]]) {
                        len++;
                        t = edges[i][0] - 1;
                    }
                }
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}

