package sgginterview;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author :  PF_23
 * @Description :多线程中，第3种获得多线程的方式
 * @date : 2020/04/10.
 */
/*class MyThread implements Runnable{
    public void run(){

    }
}*/

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() {
        System.out.println(".........come in callable");
        return 1024;
    }
}

public class CallbleDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        Thread t1 = new Thread(futureTask, "AA");
        Thread t2 = new Thread(futureTask, "BB");
        t1.start();
        int r1 = 100;
//        while (!futureTask.isDone()) {
//
//        }
        //建议放在最后。要求获得Callable线程的计算结果，如果没有计算完成就要强求，会导致阻塞，直到计算完成。
        int r2 = futureTask.get();
        System.out.println(".....result:" + r1 + r2);
    }
}

