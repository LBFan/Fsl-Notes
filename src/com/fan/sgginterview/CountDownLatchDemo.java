package com.fan.sgginterview;

import java.util.concurrent.CountDownLatch;

/**
 * @author :  PF_23
 * @Description : CountDownLatch例子
 * @date : 2020/04/10.
 */

public class CountDownLatchDemo {

//    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(6);
//        for (int i = 1; i <= 6; i++) {
//            new Thread(() -> {
//                System.out.println(Thread.currentThread().getName() + " \t 上完自习，离开教室。");
//                countDownLatch.countDown();
//            }, String.valueOf(i)).start();
//        }
//
//        countDownLatch.await();
//        // 没有await()方法时；
//        // 2 	 上完自习，离开教室。
//        //
//        //
//        //
//        //5 	 上完自习，离开教室。
//        //main	 ******班长最后关门走人
//        //4 	 上完自习，离开教室。
//        //3 	 上完自习，离开教室。
//        //1 	 上完自习，离开教室。
//        //6 	 上完自习，离开教室。
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println(Thread.currentThread().getName() + "\t ******班长最后关门走人");
//
//    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "国被灭。");
                countDownLatch.countDown();
            }, i + "\t" + CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }

        countDownLatch.await();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(Thread.currentThread().getName() + "\t ******秦帝国一统华夏");

    }
}

