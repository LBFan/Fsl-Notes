package classload;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/12/18.
 */

public class Test3 {
    private static final String AAA = getFinal();

    private static String getFinal() {
        System.out.println("父类定义的final常量");
        return null;
    }

    private static String name = getName();

    private String address = getAddress();

    static{
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类代码块");
    }

    public Test3() {
        System.out.println("父类构造函数");
    }

    private String getAddress() {
        System.out.println("父类成员变量");
        return null;
    }

    private static String getName() {
        System.out.println("父类静态变量");
        return null;
    }

}

