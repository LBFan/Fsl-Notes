package com.fan.exam.jianzhioffer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Description :滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1} 及滑动窗口的大小 3，
 * 那么一共存在 6 个滑动窗口，他们的最大值分别为 {4, 4, 6, 6, 6, 5}。
 * @Author : shulin.fan
 * @Date : 2020/7/18
 */
public class Num59 {
    public List<Integer> maxInWindows(int[] num, int k) {
        List<Integer> res = new ArrayList<>();

        // 大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // 堆大小为K
        for (int i = 0; i < k; i++) {
            queue.add(num[i]);
        }
        res.add(queue.peek());
        for (int i = 0, j = i + k; j < num.length; i++, j++) {
            queue.remove(num[i]);
            queue.add(num[j]);
            res.add(queue.peek());
        }
        return res;
    }
}