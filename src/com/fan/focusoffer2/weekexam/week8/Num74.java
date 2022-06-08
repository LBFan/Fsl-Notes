package com.fan.focusoffer2.weekexam.week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author : PF_23
 * @Description : 合并区间
 * @date : 2022/5/14 10:41.
 */

public class Num74 {

    public int[][] merge(int[][] intervals) {
        // 先按照数组对第一个数字排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> merged = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int[] tmp = new int[]{intervals[i][0], intervals[i][1]};
            int j = i + 1;
            while (j < intervals.length && intervals[j][0] <= tmp[1]) {
                tmp[1] = Math.max(tmp[1], intervals[j][1]);
                j++;
            }
            merged.add(tmp);

            i = j;
        }

        int[][] result = new int[merged.size()][];
        return merged.toArray(result);
    }
}

