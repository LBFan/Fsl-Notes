package com.fan.focusoffer2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : PF_23
 * @Description : 滑动窗口的平均值
 * 使用队列实现
 * @date : 2022/3/31 22:56.
 */

public class Num41 {

    private Queue<Integer> nums;

    private int sum;
    private int size;

    public Num41(int size) {
        nums = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        // 先将当前值放入队列，再看是否超出队列大小
        nums.offer(val);
        sum += val;
        if (nums.size() > size) {
            sum -= nums.poll();
        }

        return (double) sum / nums.size();

    }

}

