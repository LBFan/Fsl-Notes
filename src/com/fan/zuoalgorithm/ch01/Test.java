package com.fan.zuoalgorithm.ch01;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/11/04.
 */

public class Test {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {4,5,6,7};
        a = b;
        byte c = (byte) 0b10000010;
        // 有符号右移，原高位是什么，右移后高位依然是什么
        c = (byte) (c >> 1);
        System.out.println(c);
        System.out.println(Arrays.toString(a));
    }
}

