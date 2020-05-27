package thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/03/04.
 */

public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println(1);
            c.countDown();
            System.out.println(2);
            c.countDown();
        }).start();
        c.await();
        System.out.println(3);
    }
}

