package com.fan.sgginterview;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author :  PF_23
 * @Description : CyclicBarrierDemo
 * 循环栅栏例子
 * @date : 2020/04/10.
 */

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> System.out.println("*******召唤神龙"));
        for (int i = 1; i <= 7; i++) {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 搜集到第" + tempInt + "颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

        /// 1	 搜集到第1颗龙珠
        //5	 搜集到第5颗龙珠
        //4	 搜集到第4颗龙珠
        //7	 搜集到第7颗龙珠
        //2	 搜集到第2颗龙珠
        //3	 搜集到第3颗龙珠
        //6	 搜集到第6颗龙珠
        //*******召唤神龙

    }
}

