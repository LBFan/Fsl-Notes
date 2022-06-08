package com.fan.focusoffer2.weekexam.week7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author : PF_23
 * @Description : 和最小的k个数对
 * @date : 2022/4/16 10:13.
 */

public class Num61 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o2[0] + o2[1] - o1[0] - o1[1]);
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                if (maxHeap.size() >= k) {
                    if (maxHeap.peek()[0] + maxHeap.peek()[1] > nums1[i] + nums2[j]) {
                        maxHeap.poll();
                    }
                }
                maxHeap.offer(new int[]{nums1[i], nums2[j]});
            }
        }

        // 现在就是求出maxHeap中的所有数对
        List<List<Integer>> res = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            int[] poll = maxHeap.poll();
            res.add(Arrays.asList(poll[0], poll[1]));
        }
        return res;
    }
}

