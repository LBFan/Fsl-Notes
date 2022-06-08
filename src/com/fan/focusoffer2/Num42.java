package com.fan.focusoffer2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : PF_23
 * @Description : 最近请求次数
 * @date : 2022/3/31 23:07.
 */

public class Num42 {

    private Queue<Integer> times;
    private int windowSize;

    public Num42() {
        times = new LinkedList<>();
        windowSize = 3000;
    }

    public int ping(int t) {
        // 使用队列解决
        times.offer(t);
        while (times.peek() + windowSize < t) {
            times.poll();
        }
        return times.size();
    }
}

