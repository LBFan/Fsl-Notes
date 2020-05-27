package jvm.cha07;

/**
 * @author :  PF_23
 * @Description : 3种被动引用示例：不会触发类初始化
 * @date : 2020/04/08.
 */

public class NotInitialization {
    public static void main(String[] args) {
        // 1
        // superClass init
        //123
//        System.out.println(SubClass.value);

        // 2
        // 无任何输出:说明没有触发SuperClass初始化
//        SuperClass[] sca = new SuperClass[10];

        // 3
        // 没有输出"constant init" ，编译阶段以及将常量放在了常量池中，即在调用常量时没有constClass类的符号引用入口。
        // 即这两个类在编译成class之后就不存在联系了
        // 123
//        System.out.println(ConstClass.HELLO_WORLD);

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));

        /// out:
        //true
        //false
        //true
        //true
        //true
        //false
    }
}

