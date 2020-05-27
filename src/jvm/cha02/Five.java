package jvm.cha02;

/**
 * @author :  PF_23
 * @Description : 创建线程导致内存溢出异常 以后不再运行本测试
 * @date : 2020/04/07.
 */

public class Five {
    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            new Thread(() -> {
                dontStop();
            }).start();
        }
    }

    public static void main(String[] args) {
        Five oom = new Five();
        oom.stackLeakByThread();
    }
}

/**
 * Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
 * at java.lang.Thread.start0(Native Method)
 * at java.lang.Thread.start(Thread.java:717)
 * at jvm.cha02.Five.stackLeakByThread(Five.java:20)
 * at jvm.cha02.Five.main(Five.java:26)
 */

