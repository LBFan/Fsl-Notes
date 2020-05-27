package jvm;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/03/27.
 */

public class UnableCreateNativeThread {
    public static void main(String[] args) {
        for (int i = 0; ; i++) {
            System.out.println("************i=" + i);

            new Thread(() -> {
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

