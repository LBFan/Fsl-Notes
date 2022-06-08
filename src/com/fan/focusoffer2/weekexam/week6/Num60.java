package com.fan.focusoffer2.weekexam.week6;

import java.util.*;

/**
 * @author : PF_23
 * @Description : 出现频率最高的K个数字
 * @date : 2022/4/9 12:24.
 */

public class Num60 {

    //堆
    public int[] topK(int[] nums, int k) {
        int[] res = new int[k];
        // 先统计每个数字出现的次数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 然后使用小顶堆记录: int包含两个数字，第一个数字是出现的数字，第二个是出现的次数（key(0),value(1)）,注意，要自定义比较器
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));
        for (Map.Entry<Integer, Integer> integerIntegerEntry : countMap.entrySet()) {
            int key = integerIntegerEntry.getKey(), value = integerIntegerEntry.getValue();
            if (minHeap.size() < k) {
                minHeap.offer(new int[]{key, value});
            } else if (value > minHeap.peek()[1]) {
                minHeap.poll();
                minHeap.offer(new int[]{key, value});
            }
        }

        int i = 0;
        while (!minHeap.isEmpty()) {
            res[i++] = minHeap.poll()[0];
        }

        return res;
    }
}

