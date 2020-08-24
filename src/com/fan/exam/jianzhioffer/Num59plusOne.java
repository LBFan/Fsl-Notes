package com.fan.exam.jianzhioffer;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Description :
 * @Author : shulin.fan
 * @Date : 2020/8/24
 */
public class Num59plusOne {
    Queue<Integer> queue;
    Queue<Integer> maxQueue;

    public Num59plusOne() {
        this.queue = new ArrayDeque<>();
        this.maxQueue = new ArrayDeque<>();
    }

    public int max_value() {
        if (maxQueue.isEmpty()) {
            return -1;
        }
        return maxQueue.peek();
    }

    public void push_back(int value) {
        queue.add(value);
        if (max_value() < value) {
            maxQueue.poll();
            maxQueue.add(value);
        }
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        if (queue.peek().equals(maxQueue.peek())) {
            maxQueue.poll();
        }
        return queue.peek();
    }
}
