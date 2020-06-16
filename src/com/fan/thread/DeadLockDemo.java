package com.fan.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/03/26.
 */

public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThred(lockA, lockB), "ThreadAAA").start();
        new Thread(new HoldLockThred(lockB, lockA), "ThreadBBB").start();
    }

}

class HoldLockThred implements Runnable {

    private String lockA;
    private String lockB;


    public HoldLockThred(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有 " + lockA + "\t 尝试获得 " + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有 " + lockB + "\t " +
                        "尝试获得 " + lockA);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
