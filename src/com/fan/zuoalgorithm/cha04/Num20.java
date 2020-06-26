package com.fan.zuoalgorithm.cha04;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  PF_23
 * @Description : 数组中的最长连续序列
 * @date : 2020/03/21.
 */

public class Num20 {
    /**
     * 利用哈希表实现
     *
     * @param arr
     * @return
     */
    public int longestConsecutive(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
                if (map.containsKey(arr[i] - 1)) {
                    max = Math.max(max, merge(map, arr[i] - 1, arr[i]));
                }
                if (map.containsKey(arr[i] + 1)) {
                    max = Math.max(max, merge(map, arr[i], arr[i] + 1));
                }
            }
        }
        return max;
    }

    private int merge(Map<Integer, Integer> map, int less, int more) {
        int left = less - map.get(less) + 1;
        int right = more + map.get(more) - 1;
        int len = right - left + 1;
        map.put(right, len);
        map.put(less, len);
        return len;
    }
}

