package focusonoffer.single;

/**
 * @Description :
 * @Author : fanshulin
 * @Date : 2020/5/27
 */
public class Singleton04 {
    private static volatile Singleton04 instance = null;

    public static Singleton04 getInstance() {
        if (instance == null) {
            synchronized (Singleton04.class) {
                if (instance == null) {
                    instance = new Singleton04();
                }
            }
        }
        return instance;
    }
}
