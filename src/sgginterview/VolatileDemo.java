package sgginterview;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author :  PF_23
 * @Description : volatile代码演示
 * @date : 2020/04/03.
 */

class MyData {
    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }

    public void addPlusPlus() {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addMyAtommic() {
        atomicInteger.getAndIncrement();
    }
}

/**
 * 验证volatile的可见性
 * 1.1. number变量没有volatile修饰，就没有可见性
 *
 * @author HuXin
 */
public class VolatileDemo {
    public static void main(String[] args) {
//        seeOkByVolatile();

        MyData myData = new MyData();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtommic();
                }
            }, String.valueOf(i)).start();
        }

        while(Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t finally number value " + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t finally number value " + myData.atomicInteger);
    }

    /**
     * 1 验证volatile的可见性
     * 1.1 加入int number=0，number变量之前根本没有添加volatile关键字修饰,没有可见性
     * 1.2 添加了volatile，可以解决可见性问题
     * 2 验证volatile不保证原子性
     * <p>
     * 2.1 原子性是不可分割，完整性，也即某个线程正在做某个具体业务时，中间不可以被加塞或者分割。
     * 需要整体完成，要么同时成功，要么同时失败。
     * <p>
     * 2.2 volatile不可以保证原子性演示
     * <p>
     * 2.3 如何解决原子性
     * *加sync
     * *使用我们的JUC下AtomicInteger
     */
    private static void seeOkByVolatile() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t update number value: " + myData.number);
        }, "AAA").start();

        // 第2个线程就是main线程
        while (myData.number == 0) {
            // main一直等待， 直到不为0，内存不可见，那么久一直等待，死循环。
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over, main get value:" + myData.number);
    }


}

