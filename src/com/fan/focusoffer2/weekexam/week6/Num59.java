package com.fan.focusoffer2.weekexam.week6;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : PF_23
 * @Description : 数据流的第k大数字
 * @date : 2022/4/9 12:16.
 */

public class Num59 {
    //堆
    private PriorityQueue<Integer> minHeap;

    private int size;

    public Num59(int k, int[] nums) {
        size = k;
        minHeap = new PriorityQueue<>();
        //    大顶堆
        //    maxHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int num : nums) {
            add(num);
        }
    }

    private int add(int num) {
        if (minHeap.size() < size) {
            minHeap.offer(num);
        } else if (num > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(num);
        }

        return minHeap.peek();
    }
}

