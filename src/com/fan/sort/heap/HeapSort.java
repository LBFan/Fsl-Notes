package com.fan.sort.heap;

import com.fan.sort.Sort;

/**
 * @author :  PF_23
 * @Description :堆排序
 * 把最大元素和当前堆中数组的最后一个元素交换位置，并且不删除它，
 * 那么就可以得到一个从尾到头的递减序列，从正向来看就是一个递增序列，这就是堆排序。
 * <p>
 * 5.1 构建堆
 * 无序数组建立堆最直接的方法是从左到右遍历数组进行上浮操作。
 * 一个更高效的方法是从右至左进行下沉操作，如果一个节点的两个节点都已经是堆有序，
 * 那么进行下沉操作可以使得这个节点为根节点的堆有序。叶子节点不需要进行下沉操作，
 * 可以忽略叶子节点的元素，因此只需要遍历一半的元素即可。
 * <p>
 * 5.2 交换堆顶元素与最后一个元素
 * 交换之后需要进行下沉操作维持堆的有序状态。
 * <p>
 * <p>
 * 一个堆的高度为 logN，因此在堆中插入元素和删除最大元素的复杂度都为 logN。
 * 对于堆排序，由于要对 N 个节点进行下沉操作，因此复杂度为 NlogN。
 * 堆排序是一种原地排序，没有利用额外的空间。
 * 现代操作系统很少使用堆排序，因为它无法利用局部性原理进行缓存，也就是数组元素很少和相邻的元素进行比较和交换。
 * @date : 2019/11/29.
 */

public class HeapSort<T extends Comparable<T>> extends Sort<T> {
    /**
     * 数组第 0 个位置不能有元素
     */
    @Override
    public void sort(T[] nums) {
        int N = nums.length - 1;
        for (int k = N / 2; k >= 1; k--) {
            sink(nums, k, N);
        }

        while (N > 1) {
            swap(nums, 1, N--);
            sink(nums, 1, N);
        }
    }

    private void sink(T[] nums, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(nums, j, j + 1)) {
                j++;
            }
            if (!less(nums, k, j)) {
                break;
            }
            swap(nums, k, j);
            k = j;
        }
    }

    private boolean less(T[] nums, int i, int j) {
        return nums[i].compareTo(nums[j]) < 0;
    }
}

