package com.fan.leetcode.greedy;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 分配饼干
 * 题目描述：每个孩子都有一个满足度 grid，每个饼干都有一个大小 size，
 * 只有饼干的大小大于等于一个孩子的满足度，该孩子才会获得满足。求解最多可以获得满足的孩子数量。
 * <p>
 * Input: grid[1,3], size[1,2,4]
 * Output: 2
 *
 * 给一个孩子的饼干应当尽量小并且又能满足该孩子，这样大饼干才能拿来给满足度比较大的孩子。
 * 因为满足度最小的孩子最容易得到满足，所以先满足满足度最小的孩子。
 * @date : 2020/01/15.
 */

public class Num01 {
    public int findContentChildren(int[] grid, int[] size) {
        if (grid == null || size == null) {
            return 0;
        }
        Arrays.sort(grid);
        Arrays.sort(size);
        int m = grid.length;
        int n = size.length;
        int gi = 0, si = 0;
        while (gi < m && si < n) {
            if (grid[gi] <= size[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}

