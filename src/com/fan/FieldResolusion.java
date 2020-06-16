package com.fan;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/02/23.
 */

public class FieldResolusion {
    static class Parent {
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}

