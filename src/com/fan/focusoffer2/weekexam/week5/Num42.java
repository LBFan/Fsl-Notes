package com.fan.focusoffer2.weekexam.week5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : PF_23
 * @Description : 最近请求次数
 * @date : 2022/4/3 10:16.
 */

public class Num42 {
    private Queue<Integer> queue;

    private int window;

    public Num42(int window) {
        this.queue = new LinkedList<>();
        this.window = 3000;
    }

    /**
     * 返回容量大小
     *
     * @param t
     * @return
     */
    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() + window < t) {
            queue.poll();
        }

        return queue.size();
    }
}

