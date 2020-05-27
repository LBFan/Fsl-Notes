package sgginterview;

import java.lang.ref.SoftReference;

/**
 * @author :  PF_23
 * @Description : 软连接测试Demo
 * @date : 2020/04/11.
 */

public class SoftReferenceDemo {
    /**
     * 内存够用的时候就保留，不够用就回收
     */
    public static void softRef_Memory_Enough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(softReference.get());
    }

    public static void softRef_Memory_NotEnough() {
        Object o2 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o2);
        System.out.println(o2);
        System.out.println(softReference.get());

        o2 = null;
        try {
            byte[] bytes = new byte[30*1024*1024];
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(o2);
            System.out.println(softReference.get());
        }
    }

    public static void main(String[] args) {
        System.out.println("softRef_Memory_Enough:");
        softRef_Memory_Enough();
        System.out.println("******************************");
        System.out.println("softRef_Memory_NotEnough:");
        softRef_Memory_NotEnough();
    }
}

