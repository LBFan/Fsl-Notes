package com.fan.hanshunping.datastructrue.sort;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 插入排序
 * 是对于欲排序的元素以插入的方式找寻该元素的适当位置，以达到排序的目的。
 * 把 n 个待排序的元素看成为一个有序表和一个无序表，开始时有 序表中只包含一个元素，无序表中包含有 n-1 个元素，
 * 排序过程中每次从无序表中取出第一个元素，把它的排 序码依次与有序表元素的排序码进行比较，将它插入到有序表中的适当位置，
 * 使之成为新的有序表。
 * @date : 2020/03/17.
 */

public class InsertSort {
    public static void insertSort(int[] arr) {
        int insertVal;
        int insertIndex;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;

            // 给 insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给 insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 当退出 while 循环时，说明插入的位置找到, insertIndex + 1
            // 这里我们判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

    public static void main(String[] args) {
        int[] num = {9, 8, 3, 6, 4, 1, 2};
        InsertSort.insertSort(num);
        System.out.println(Arrays.toString(num));
    }
}

