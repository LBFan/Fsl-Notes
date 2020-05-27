package singleton;

/**
 * @author :  PF_23
 * @Description : 单例模式
 * 枚举-线程安全 - 该实现可以防止反射攻击
 * @date : 2020/04/02.
 */

public enum Singleton06 {

    /**
     * 单例
     */
    INSTANCE;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

