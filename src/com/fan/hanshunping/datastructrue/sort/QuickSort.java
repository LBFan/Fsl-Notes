package com.fan.hanshunping.datastructrue.sort;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 快速排序
 * 快速排序(Quicksort)是对冒泡排序的一种改进。基本思想是:通过一趟排序将要排序的数据分割成独立的两 部分，
 * 其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排 序，
 * 整个排序过程可以递归进行，以此达到整个数据变成有序序列
 * @date : 2020/04/15.
 */

public class QuickSort {

    public static void quickSort01(int[] arr, int l, int h) {
        if (h <= l) {
            return;
        }
        int j = partition(arr, l, h);
        quickSort01(arr, l, j - 1);
        quickSort01(arr, j + 1, h);
    }

    private static int partition(int[] arr, int l, int h) {
        int i = l, j = h + 1;
        int value = arr[l];
        while (true) {
            while (arr[++i] < value && i != h) {

            }
            while ((arr[--j] > value && j != l)) {

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
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];

        int temp;
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }

        // 如果 l == r, 必须 l++, r--, 否则会出现栈溢出
        if (l == r) {
            l++;
            r--;
        }

        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    public static void main(String[] args) {
        int[] num = {9, 8, 3, 6, 4, 1, 2};
        quickSort01(num, 0, num.length - 1);
        System.out.println(Arrays.toString(num));
    }
}

