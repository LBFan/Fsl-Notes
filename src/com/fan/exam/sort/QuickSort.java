package com.fan.exam.sort;

/**
 * @Description :
 * @Author : shulin.fan
 * @Date : 2020/7/5
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int h) {
        if (h <= l) {
            return;
        }
        int j = partition(arr, l, h);
        quickSort(arr, l, j - 1);
        quickSort(arr, j + 1, h);
    }

    private static int partition(int[] arr, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (arr[++i] < arr[l] && i != h) {

            }
            while (arr[--j] > arr[l] && j != l) {

            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int t= arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
