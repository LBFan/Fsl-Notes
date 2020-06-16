package com.fan.sgginterview;

public class StrongReferenceDemo {
    public static void main(String[] args) {
        //这样定义默认的就是强引用
        Object obj1 = new Object();
        //obj2引用赋值
        Object obj2 = obj1;
        obj1 = null;
        System.gc();
        // java.lang.Object@2503dbd3
        System.out.println(obj2);
    }
}