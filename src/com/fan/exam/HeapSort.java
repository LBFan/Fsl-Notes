package com.fan.exam;

/**
 * @Description :
 * @Author : shulin.fan
 * @Date : 2020/7/5
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        int temp;

        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // 调整
            adjustHeap(arr, 0, i);
        }
    }

    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];

        for (int k = 2 * i + 1; k < arr.length; k = 2 * k + 1) {
            if (k + 1 < arr.length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[k] = arr[i];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }
}
