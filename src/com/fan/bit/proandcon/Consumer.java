package com.fan.bit.proandcon;

import java.util.concurrent.BlockingQueue;

/**
 * @author pf23
 */
public class Consumer {
    BlockingQueue<Apple> queue;

    public Consumer(BlockingQueue<Apple> queue) {
        this.queue = queue;
    }

    public Apple take() throws InterruptedException {
        return queue.take();
    }
}