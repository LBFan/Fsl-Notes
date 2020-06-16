package com.fan.sort.merge;

import com.fan.sort.Sort;

/**
 * @author :  PF_23
 * @Description : 归并方法：归并方法将数组中两个已经排序的部分归并成一个
 * @date : 2019/11/29.
 */

public abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {

    protected T[] aux;


    protected void merge(T[] nums, int l, int m, int h) {
        int i = l, j = m + 1;
        for (int k = 0; k < h; k++) {
            // 将元素放在辅助数组中
            aux[k] = nums[k];
        }

        for (int k = l; k < h; k++) {
            if (i > m) {
                nums[k] = aux[j++];
            } else if (j > h) {
                nums[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) <= 0) {
                // 先进行这一步，保证稳定性
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
            }
        }
    }
}

