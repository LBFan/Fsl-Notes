package com.fan.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/03/04.
 */

public class CountDownLatchTest {
//    static CountDownLatch c = new CountDownLatch(2);
//
//    public static void main(String[] args) throws InterruptedException {
//        new Thread(() -> {
//            System.out.println(1);
//            c.countDown();
//            System.out.println(2);
//            c.countDown();
//        }).start();
//        c.await();
//        System.out.println(3);
//    }

    volatile List<Integer> list = new ArrayList<>();

    public void add(int i) {
        list.add(i);
    }

    public int getSize() {
        return list.size();
    }

    public static void main(String[] args) {
        CountDownLatchTest test = new CountDownLatchTest();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2 start");
            if (test.getSize() != 5) {
                try {
                    countDownLatch.await();
                    System.out.println("t2 end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();

        new Thread(() -> {
            System.out.println("t1 start");
            for (int i = 0; i <= 9; i++) {
                test.add(i);
                System.out.println("add" + i);
                if (test.getSize() == 5) {
                    System.out.println("countdown is open");
                    countDownLatch.countDown();
                }
            }
            System.out.println("t1 end");
        }, "t1").start();
    }
}

