package jvm.cha07;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/04/08.
 */

public class ConstClass {
    static {
        System.out.println("Constant init");
    }
    public final static int HELLO_WORLD = 123;
}

