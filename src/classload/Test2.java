package classload;


/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/12/18.
 */

public class Test2 extends Test3 {
    {
        System.out.println("子类代码块");
    }
    private String address = getAddress();

    static{
        System.out.println("子类静态代码块");
    }
    private static String name = get1Name();



    public Test2() {
        System.out.println("子类构造方法");
    }

    private String getAddress() {
        System.out.println("子类成员变量");
        return null;
    }

    private static String get1Name() {
        System.out.println("子类静态变量");
        return null;
    }

    private static final String AAA = getFinal();

    private static String getFinal() {
        System.out.println("子类定义的final常量");
        return null;
    }
}

