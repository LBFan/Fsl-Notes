package com.fan.zuoalgorithm.ch01;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author :  PF_23
 * @Description : 生成窗口最大值数组
 * @date : 2019/11/04.
 */

public class Num07 {

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }

        // 维护一个递减的双端队列：队头元素为最大值
        LinkedList<Integer> qMax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[i]) {
                qMax.pollLast();
            }
            qMax.addLast(i);
            // 队头过期
            if (qMax.peekFirst() == (i - w)) {
                qMax.pollFirst();
            }
            // 每次滑动都会有结果出现
            if (i >= w - 1) {
                res[index++] = arr[qMax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        Num07 num07 = new Num07();
        int[] arr = {4,3,5,4,3,3,6,7};
        int w = 3;
        int[] maxWindow = getMaxWindow(arr, w);
        System.out.println(Arrays.toString(maxWindow));
    }
}

