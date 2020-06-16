package com.fan.thread;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :  PF_23
 * @Description : 多线程有序打印1和2，分别打印10次
 * @date : 2020/03/02.
 */

public class PrintOneTwo {
    private Lock lock = new ReentrantLock();

    private static final String NAME_ONE = "one";
    private static final String NAME_TWO = "two";

    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    //    Condition conditionC = lock.newCondition();
    private String curThreadName = "one";



    private class Thread1 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (!NAME_ONE.equals(curThreadName)) {
                        /*
                         * 如果当前线程名字不是A，那么ThreadA就处理等待状态
                         */
                        try {
                            condition1.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    /*
                     * 打印出第几遍以及A信息
                     */
                    System.out.println(String.format("第%d遍打印", i + 1));
                    System.out.println(1);
                    /*
                     * 将当前线程名置为B， 然后通知ThreadB执行
                     */
                    curThreadName = NAME_TWO;
                    condition2.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private class Thread2 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (!NAME_TWO.equals(curThreadName)) {
                        /*
                         * 如果当前线程名字不是A，那么ThreadA就处理等待状态
                         */
                        try {
                            condition2.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    /*
                     * 打印出第几遍以及A信息
                     */
                    System.out.println(String.format("第%d遍打印", i + 1));
                    System.out.println(2);
                    /*
                     * 将当前线程名置为B， 然后通知ThreadB执行
                     */
                    curThreadName = NAME_ONE;
                    condition1.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
//        PrintOneTwo printOneTwo = new PrintOneTwo();
//        ExecutorService service = Executors.newFixedThreadPool(2);
//        service.execute(printOneTwo.new Thread1());
//        service.execute(printOneTwo.new Thread2());
//
//        service.shutdown();

        String a = new String();
        String b = new String();
        // true
        System.out.println(a.equals(b));
        // false
        System.out.println(a == b);
//        Collection;
//        Collections
    }


}

