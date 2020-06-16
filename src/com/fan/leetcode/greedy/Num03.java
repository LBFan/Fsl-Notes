package com.fan.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author :  PF_23
 * @Description : 投飞镖刺破气球
 * <p>
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 * Output:
 * 2
 * 题目描述：
 * 解释:
 * 对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
 * @date : 2020/01/15.
 */

public class Num03 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0 || points[0].length == 0) {
            return 0;
        }
        // 按照尾元素排序
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int cnt = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
            }
            cnt++;
            end = points[i][1];
        }
        return cnt;
    }
}

