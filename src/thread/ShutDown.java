package thread;

import java.util.concurrent.TimeUnit;

/**
 * @author :  PF_23
 * @Description : 安全地终止线程
 * @date : 2020/04/09.
 */

public class ShutDown {
    public static void main(String[] args) {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        // 睡眠一秒，main线程对CountThread进行中断，使CountThread能够感知中断而结束
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 标识位:起到通知中断而结束的效果
        countThread.interrupt();
        Runner two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        two.cancel();
    }

    private static class Runner implements Runnable {

        private long i;

        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i = " + i);
        }

        public void cancel() {
            on = false;
        }
    }
}

