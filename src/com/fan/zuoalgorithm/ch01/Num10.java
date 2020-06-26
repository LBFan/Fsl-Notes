package com.fan.zuoalgorithm.ch01;

import java.util.LinkedList;

/**
 * @author :  PF_23
 * @Description : 最大值减去最小值小于或等于num的子数组数量
 * @date : 2019/11/07.
 */

public class Num10 {
    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0 || num < 0) {
            return 0;
        }
        LinkedList<Integer> qMin = new LinkedList<>();
        LinkedList<Integer> qMax = new LinkedList<>();
        int i = 0, j = 0;
        int res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                if (qMin.isEmpty() || arr[qMin.peekLast()] != j) {
                    // 维护一个自底向上的递增双端队列 qMin.peekLast()是qMin双端队列中最大的值
                    while (!qMin.isEmpty() && arr[qMin.peekLast()] >= arr[j]) {
                        qMin.pollLast();
                    }
                    qMin.addLast(j);
                    // 维护一个自底向上的递双端队列 qMax.peekLast()是qMax双端队列中最小的值
                    while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[j]) {
                        qMax.pollLast();
                    }
                    qMax.addLast(j);
                }
                if (arr[qMax.getFirst()] - arr[qMin.getFirst()] > num) {
                    break;
                }
                j++;
            }
            res += j - i;
            // 跟新最小值：因为i++
            if (qMin.peekFirst() == i) {
                qMin.pollFirst();
            }
            // 跟新最大值：因为i++
            if (qMax.peekFirst() == i) {
                qMax.pollFirst();
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 3, 5, 6, 4, 5, 7};
        int num = 3;
        int res = getNum(arr, num);
        System.out.println(res);
    }

}

