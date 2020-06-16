package com.fan.sgginterview;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author :  PF_23
 * @Description :阻塞队列Demo
 * ArrayBlockingQueue:是一个基于数组结构的有界阻塞队列，此队列按FIFO原则对元素进行排序
 * LinkedBlockingQueue:是一个基于链表结构的阻塞队列，此队列按FIFO排序元素，吞吐量高于ArrayBlockingQueue
 * SynchronousQueue：一个不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移出操作，否则插入操作一直处于
 * 阻塞状态，吞吐量通常要高
 * <p>
 * 2.阻塞队列
 * 2.1阻塞队列有没有好的一面
 * 2.2不得不阻塞，你如何管理
 * @date : 2020/04/10.
 */

public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception {

        // 四组返回组异常情况对比
        //        List list = null;
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
//        往阻塞队列添加元素
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        //Exception in thread "main" java.lang.IllegalStateException: Queue full
        //	at java.util.AbstractQueue.add(AbstractQueue.java:98)
        //	at java.util.concurrent.ArrayBlockingQueue.add(ArrayBlockingQueue.java:312)
        //	at sgginterview.BlockingQueueDemo.main(BlockingQueueDemo.java:29)
//        System.out.println(blockingQueue.add("x"));

//        从阻塞队列取元素
//        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        // Exception in thread "main" java.util.NoSuchElementException
        //	at java.util.AbstractQueue.remove(AbstractQueue.java:117)
        //	at sgginterview.BlockingQueueDemo.main(BlockingQueueDemo.java:41)
//        System.out.println(blockingQueue.remove());

//        System.out.println(blockingQueue.element());
    }
}

