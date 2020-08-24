package com.fan.exam.jianzhioffer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Description : 最小的K个数
 * @Author : shulin.fan
 * @Date : 2020/7/16
 */
public class Num40 {
    /**
     * 快速排序法 复杂度：O(N) + O(1)  本方法只有当允许修改数组元素时才可以使用
     * 快速排序的 partition() 方法，
     * 会返回一个整数 j 使得 a[l..j-1] 小于等于 a[j]，且 a[j+1..h] 大于等于 a[j]，此时 a[j] 就是数组的第 j 大元素。
     * 可以利用这个特性找出数组的第 K 个元素，这种找第 K 个元素的算法称为快速选择算法。
     *
     * @param nums 数组
     * @param k    个数
     * @return 前k个数的集合
     */
    public static List<Integer> getLeastNumbersSolution(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        /* findKthSmallest 会改变数组，使得前 k（下标为0 ~ k - 1） 个数都是最小的 k 个数 */
        findKthSmallest(nums, k - 1);
        for (int i = 0; i < k; i++) {
            res.add(nums[i]);
        }
        return res;
    }

    private static void findKthSmallest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j > k) {
                h = j;
            } else {
                l = j + 1;
            }
        }
    }

    private static int partition(int[] nums, int l, int h) {
        int i = l, j = h + 1;
        // 切分元素
        int p = nums[l];
        while (i < j) {
            while (i < h && nums[++i] < p) {

            }
            while (j > l && nums[--j] > p) {

            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1,6,7,4,5,9,8,2};
        int k = 4;
        List<Integer> integers = getLeastNumbersSolution(nums, k);
        System.out.println(integers.toString());
    }

    /**
     * 大小为 K 的最小堆  复杂度：O(NlogK) + O(K) 本方法特别适合处理海量数据
     * 应该使用大顶堆来维护最小堆，而不能直接创建一个小顶堆并设置一个大小，企图让小顶堆中的元素都是最小元素。
     * 维护一个大小为 K 的最小堆过程如下：在添加一个元素之后，如果大顶堆的大小大于 K，那么需要将大顶堆的堆顶元素去除。
     *
     * @param nums 数组
     * @param k    个数
     * @return 前k个最小的数的集合
     */
    private static List<Integer> GetLeastNumbers_heapSolution(int[] nums, int k) {
        if (k > nums.length || k <= 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return new ArrayList<>(queue);
    }
}
