package singleton;

/**
 * @author :  PF_23
 * @Description : 单例模式
 * 懒汉式-线程安全
 * @date : 2020/04/02.
 */

public class Singleton03 {

    /**
     * 初始时即加载
     */
    private static Singleton03 instance;

    private Singleton03() {

    }

    /**
     * 加锁
     * 这会让线程阻塞时间过长，因此该方法有性能问题，不推荐使用
     *
     * @return
     */
    public static synchronized Singleton03 getInstance() {
        if (instance == null) {
            instance = new Singleton03();
        }
        return instance;
    }
}

