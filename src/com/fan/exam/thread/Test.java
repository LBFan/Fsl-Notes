package com.fan.exam.thread;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/12/19.
 */

public class Test {
    public static void main(String[] args) {
//        new Thread(() -> System.out.println(System.currentTimeMillis())).start();
//        int i = 2;
//        i = 5;
//        System.out.println(i);
//        int m = -1;
//        int n = 8;
//        int t = m / n;
//        System.out.println(t);
//
//        int a = 3;
//        int swap = swap(a);
//        System.out.println(a);

        int i = 0;
        while (true) {
            // 死循环
            i++;
            if (i == Integer.MAX_VALUE) {
                System.out.println("reset");
            }
            i = 0;
        }
    }

    public static int get(int node, int k) {
        int sum = (int) (node - Math.pow(2, k) + 1);
        if (sum >= 0) {
            return (int) (sum / Math.pow(2, k));
        }
        return -1;
    }

    public static int swap(int a) {
        a = 5;
        return a;
    }
}

