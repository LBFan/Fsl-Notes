package com.fan.exam.jianzhioffer;

import java.util.PriorityQueue;

/**
 * @Description : 数据流中的中位数
 * 用两个堆（一大一小）
 * @Author : shulin.fan
 * @Date : 2020/7/17
 */
public class Num41 {

    /**
     * 大顶堆，存储左半边元素
     */
    private static PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);

    /**
     * 小顶堆，存储右半边元素，并且右半边元素都大于左半边
     */
    private static PriorityQueue<Integer> right = new PriorityQueue<>();
    /**
     * 当前数据流读入的元素个数
     */
    private static int N = 0;

    public void Insert(Integer val) {
        if (N % 2 == 0) {
            /* 插入要保证两个堆存于平衡状态 */
            /* N 为偶数的情况下插入到右半边（小顶堆）。 然后总数为奇数 （小顶队堆的堆顶就是中位数）
             * 因为右半边元素都要大于左半边，但是新插入的元素不一定比左半边元素来的大，
             * 因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边
             */
            left.add(val);
            right.add(left.poll());
        } else {
            right.add(val);
            left.add(right.poll());
        }
        N++;
    }

    public static double getMid() {
        if (N % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return Double.valueOf(right.peek());
        }
    }
}
