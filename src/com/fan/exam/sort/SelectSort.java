package com.fan.exam.sort;

/**
 * @Description : 选择排序
 * @Author : shulin.fan
 * @Date : 2020/7/8
 */
public class SelectSort {
    public static void selectSort(int[] arr) {
        // arr.length - 1趟排序 第i趟排序是把剩余部分arr[i ... length - 1]的最小值与arr[i-1]比较，较小值放到arr[i]处
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
