package com.fan.zuoalgorithm.ch01.Num11;

/**
 * @author :  PF_23
 * @Description : 可见的山峰对数量
 * @date : 2019/11/10.
 */

public class Num11 {
    public static int getVisibleNum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        if (arr.length == 2) {
            return 1;
        }
        return (arr.length << 1) - 3;

    }
}

