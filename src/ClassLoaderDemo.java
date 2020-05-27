/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/02/21.
 */

public class ClassLoaderDemo {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader.getClass().getName());
            classLoader = classLoader.getParent();
        }
        System.out.println(String.class.getClassLoader());
    }
}

