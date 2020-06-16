package com.fan.jvm;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/03/27.
 */

public class HelloGC {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("********HelloGC");
        System.out.println(Runtime.getRuntime().availableProcessors());

//        Thread.sleep(Integer.MAX_VALUE);
    }
}

