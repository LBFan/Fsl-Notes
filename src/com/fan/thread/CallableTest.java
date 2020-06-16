package com.fan.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/12/19.
 */

public class CallableTest implements Callable<Integer> {
    public static void main(String[] args) {
        CallableTest callableTest = new CallableTest();
        FutureTask<Integer> futureTask = new FutureTask<>(callableTest);

        new Thread(futureTask).start();

        try {
            System.out.println("i * i = " + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer call() throws Exception {
        int i = 5;
        return i * i;

    }
}

