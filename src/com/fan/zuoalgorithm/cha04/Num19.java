package com.fan.zuoalgorithm.cha04;

/**
 * @author :  PF_23
 * @Description : 跳跃游戏
 * @date : 2020/03/21.
 */

public class Num19 {
    public int jump(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int jump = 0;
        int cur = 0;
        int next = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cur < i) {
                jump++;
                cur = next;
            }
            next = Math.max(next, i + arr[i]);
        }
        return jump;
    }
}

