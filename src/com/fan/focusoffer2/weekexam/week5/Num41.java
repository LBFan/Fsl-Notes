package com.fan.focusoffer2.weekexam.week5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : PF_23
 * @Description : 滑动窗口的平均值
 * @date : 2022/4/3 10:09.
 */

public class Num41 {

    private Queue<Integer> queue;

    private int window;
    int sum;

    public Num41(int window) {
        this.window = window;
        queue = new LinkedList<>();
    }

    public double getNum(int val) {
        sum += val;
        queue.offer(val);
        if (queue.size() > window) {
            sum -= queue.poll();
        }

        return (double) sum / queue.size();
    }

}

