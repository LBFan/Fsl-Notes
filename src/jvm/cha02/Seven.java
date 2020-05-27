package jvm.cha02;

/**
 * @author :  PF_23
 * @Description :javap -c Seven 查看字节码文件
 * java1.6时，会得到两个false：intern()方法会把首次遇到的字符串实例复制到永久代中，返回的也是永久代中的这个字符串实例的引用，
 * 而StringBuilder创建的字符串实例在Java堆上，所以必然不是同一个引用，将返回false
 * <p>
 * java1.7以后特别将字符串常量池移动到了的堆内存中，先得到true，然后得到false。
 * JDK1.7及以后的intern()实现不会再复制实例，只在常量池中记录首次出现的实例引用，
 * 因此intern()方法返回的引用和由StringBuilder创建的那个字符串实例是同一个。
 * 对于str2比较返回false是因为"Java"这个字符串在执行StringBuilder.toString()之前已经出现过，字符串常量池中已经有它的引用了，
 * 不符合首次出现的原则，而"计算机软件"这个字符串则是首次出现的，因此返回true。
 * @date : 2020/04/07.
 */

public class Seven {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        // true
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        // false
        System.out.println(str2.intern() == str2);
    }
}

