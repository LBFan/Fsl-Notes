package focusonoffer.single;

/**
 * @Description : 只适用于单线程环境 不好的解法
 * @Author : fanshulin
 * @Date : 2020/5/27
 */
public class Singleton01 {
    private static Singleton01 instance = null;

    public static Singleton01 getInstance() {
        if (instance == null) {
            instance = new Singleton01();
        }
        return instance;
    }
}
