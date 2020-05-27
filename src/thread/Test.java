package thread;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/12/19.
 */

public class Test {
    public static void main(String[] args) {
        new Thread(() -> System.out.println(System.currentTimeMillis())).start();
    }
}

