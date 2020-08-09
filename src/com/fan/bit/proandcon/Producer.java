package com.fan.bit.proandcon;

import java.util.concurrent.BlockingQueue;

/**
 * @author : pf23
 */
public class Producer {
    BlockingQueue<Apple> queue;

    public Producer(BlockingQueue<Apple> queue) {
        this.queue = queue;
    }

    public boolean put(Apple apple) {
        return queue.offer(apple);
    }
}