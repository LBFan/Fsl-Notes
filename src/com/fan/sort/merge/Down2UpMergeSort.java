package com.fan.sort.merge;

/**
 * @author :  PF_23
 * @Description : 自底向上归并排序
 * 先归并那些微型数组，然后成对归并得到的微型数组。
 * @date : 2019/11/29.
 */

public class Down2UpMergeSort<T extends Comparable<T>> extends MergeSort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        aux = (T[]) new Comparable[N];

        for (int sz = 1; sz < N; sz += sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(nums, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }
}

