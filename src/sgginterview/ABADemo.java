package sgginterview;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author :  PF_23
 * @Description : ABA问题的解决  AtomicStampedReference
 * @date : 2020/04/03.
 */

public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
//        new Thread(() -> {
//            atomicReference.compareAndSet(100, 101);
//            atomicReference.compareAndSet(100, 101);
//        }, "t1").start();
//
//        new Thread(() -> {
//            try {
//                /**
//                 * 暂停1秒钟线程2，保证上面t1线程完成一次ABA操作
//                 */
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, "t2").start();
//
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("========以下是ABA问题的解决");

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t 第1次版本号：" + stamp);

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t 第2次版本号：" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t 第3次版本号：" + atomicStampedReference.getStamp());
        }, "t3").start();

        new Thread(() -> {

            int stamp = atomicStampedReference.getStamp();

            System.out.println(Thread.currentThread().getName() + "\t 第1次版本号：" + stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = atomicStampedReference.compareAndSet(100, 2019, stamp, atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "修改成功与否；" + result + "\t 当前最新实际版本号：" + atomicStampedReference.getStamp());
        }, "t4").start();
    }
}

