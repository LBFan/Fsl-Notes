package com.fan.sgginterview;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/04/03.
 */

public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data " + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data " + atomicInteger.get());

    }
}

