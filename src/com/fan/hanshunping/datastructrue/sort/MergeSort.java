package com.fan.hanshunping.datastructrue.sort;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description :
 * 归并排序(MERGE-SORT)是利用归并的思想实现的排序方法，
 * 该算法采用经典的分治(divide-and-conquer) 策略(分治法将问题分(divide)成一些小的问题然后递归求解，
 * 而治(conquer)的阶段则将分的阶段得到的各答案"修 补"在一起，即分而治之)。
 * @date : 2020/04/15.
 */

public class MergeSort {

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
    }

    /**
     * 分+合方法
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            // 中间索引
            int mid = (left + right) / 2;
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            // 合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  临时数组
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 初始化 i, 左边有序序列的初始索引
        int i = left;
        // 初始化j, 右边有序序列的初始索引
        int j = mid + 1;
        // 指向 temp 数组的当前索引
        int k = 0;

        //(一)
        //先把左右两边(有序)的数据按照规则填充到 temp 数组 直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            // 即将左边的当前元素，填充到 temp 数组
            //然后 k++, i++
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                //反之,将右边有序序列的当前元素，填充到 temp 数组
                temp[k++] = arr[j++];
            }

        }
        //(二)
        //把有剩余数据的一边的数据依次全部填充到 temp
        //左边的有序序列还有剩余的元素，就全部填充到 temp
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        //(三)
        //将 temp 数组的元素拷贝到 arr
        // 注意，并不是每次都拷贝所有
        k = 0;
        int tempLeft = left;
        //第一次合并 tempLeft = 0 , right = 1 // //最后一次 tempLeft = 0 right = 7
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[k++];
        }
    }

    public static void main(String[] args) {
        int[] num = {9, 8, 3, 6, 4, 1, 2};
//        mergeSort(num, 0, num.length - 1, new int[num.length]);
        mergeSort(num);
        System.out.println(Arrays.toString(num));
    }
}

