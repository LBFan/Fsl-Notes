package sgginterview;

import java.util.concurrent.*;

/**
 * @author :  PF_23
 * @Description :
 * 第4种获得/使用java多线程的方式，通过线程池
 * （其他三种是：继承Thread类；实现Runnable接口，但是Runnable没有返回值，不抛异常；
 * 实现Callable接口，有返回值，会跑出异常）
 * @date : 2020/04/10.
 */

public class MyThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),

                // 以下是4种拒绝策略

                /**
                 * pool-1-thread-2	 办理业务
                 * pool-1-thread-4	 办理业务
                 * pool-1-thread-5	 办理业务
                 * pool-1-thread-3	 办理业务
                 * pool-1-thread-1	 办理业务
                 * pool-1-thread-4	 办理业务
                 * pool-1-thread-5	 办理业务
                 * pool-1-thread-2	 办理业务
                 * java.util.concurrent.RejectedExecutionException: Task sgginterview.MyThreadPoolDemo$$Lambda$1/1480010240@7ef20235 rejected from java.util.concurrent.ThreadPoolExecutor@27d6c5e0[Running, pool size = 5, active threads = 0, queued tasks = 0, completed tasks = 8]
                 * 	at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2063)
                 * 	at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:830)
                 * 	at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1379)
                 * 	at sgginterview.MyThreadPoolDemo.main(MyThreadPoolDemo.java:76)
                 */
//                new ThreadPoolExecutor.AbortPolicy()

                /**
                 *pool-1-thread-2	 办理业务
                 * pool-1-thread-4	 办理业务
                 * pool-1-thread-5	 办理业务
                 * pool-1-thread-3	 办理业务
                 * pool-1-thread-4	 办理业务
                 * pool-1-thread-1	 办理业务
                 * pool-1-thread-5	 办理业务
                 * pool-1-thread-2	 办理业务
                 * main	 办理业务
                 * pool-1-thread-3	 办理业务
                 * pool-1-thread-4	 办理业务
                 */
//                new ThreadPoolExecutor.CallerRunsPolicy()

                /**
                 * pool-1-thread-1	 办理业务
                 * pool-1-thread-3	 办理业务
                 * pool-1-thread-2	 办理业务
                 * pool-1-thread-1	 办理业务
                 * pool-1-thread-3	 办理业务
                 * pool-1-thread-4	 办理业务
                 * pool-1-thread-3	 办理业务
                 * pool-1-thread-1	 办理业务
                 * pool-1-thread-5	 办理业务
                 * pool-1-thread-2	 办理业务
                 */
//                new ThreadPoolExecutor.DiscardOldestPolicy()


                /**
                 * pool-1-thread-1	 办理业务
                 * pool-1-thread-3	 办理业务
                 * pool-1-thread-1	 办理业务
                 * pool-1-thread-2	 办理业务
                 * pool-1-thread-4	 办理业务
                 * pool-1-thread-4	 办理业务
                 * pool-1-thread-1	 办理业务
                 * pool-1-thread-5	 办理业务
                 * pool-1-thread-3	 办理业务
                 * pool-1-thread-4	 办理业务
                 * pool-1-thread-2	 办理业务
                 */
                new ThreadPoolExecutor.DiscardPolicy()
        );
        try {
            for (int i = 1; i <= 11; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    private static void threadPoolInit() {
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池5个处理线程
        //ExecutorService threadPool = Executors.newFixedThreadPool(1);//一池1个线程
        ExecutorService threadPool = Executors.newCachedThreadPool();//一池N个线程

        //模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}

