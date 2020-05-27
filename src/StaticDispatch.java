/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/02/25.
 */

public class StaticDispatch {
    static abstract class Human{

    }

    static class Man extends Human {

    }

    static class Woman extends Man {

    }

    public void sayHello(Human human) {
        System.out.println("hello, guy!");
    }

    public void sayHello(Man man) {
        System.out.println("hello, gentleMan!");
    }

    public void sayHello(Woman woman) {
        System.out.println("hello, lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello((Man) man);
        sr.sayHello((Woman) woman);
    }
}


