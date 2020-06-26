package com.fan.zuoalgorithm.cha04;

/**
 * @author :  PF_23
 * @Description : 汉诺塔问题
 * @date : 2020/03/21.
 */

public class Num09 {
    public void hanoi(int n) {
        if (n > 0) {
            func(n, "left", "mid", "right");
        }
    }

    private void func(int n, String from, String mid, String to) {
        if (n == 1) {
            System.out.println("move from " + from + " to " + to);
        } else {
            func(n - 1, from, to, mid);
            func(1, from, mid, to);
            func(n - 1, mid, from, to);

        }
    }
}

