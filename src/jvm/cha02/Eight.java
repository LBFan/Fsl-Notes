package jvm.cha02;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author :  PF_23
 * @Description : 本机内存直接溢出
 * 使用UNsafe分配本机内存
 * -Xmx20m -XX:MaxDirectMemorySize=10M
 * @date : 2020/04/07.
 */

public class Eight {
    private static final int _1BM = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1BM);
        }
    }
}

