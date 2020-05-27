package sort.bubble;

import sort.Sort;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 冒泡排序
 * 从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
 * <p>
 * 在一轮循环中，如果没有发生交换，那么说明数组已经是有序的，此时可以直接退出。
 * @date : 2019/11/29.
 */

public class Bubble<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        // 没有发生交换时，说明有序，不用再判断交换
        boolean isSorted = false;
        for (int i = N - 1; i > 0 && !isSorted; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (less(nums[j + 1], nums[j])) {
                    isSorted = false;
                    swap(nums, j + 1, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 3, 2, 4, 5, 6, 7};
        Bubble<Integer> bubble = new Bubble();
        bubble.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

