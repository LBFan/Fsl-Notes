package com.fan.focusonoffer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author :  PF_23
 * @Description : 最小的 K 个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @date : 2019/12/27.
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
    public static List<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        findKthSmallest(nums, k - 1);
        /* findKthSmallest 会改变数组，使得前 k（下标为0 ~ k - 1） 个数都是最小的 k 个数 */
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

    private static int partition(int[] nums, int low, int hi) {
        // 切分元素
        int p = nums[low];
        int i = low, j = hi + 1;
        while (true) {
            while (i != hi && nums[++i] < p) {

            }
            while (j != low && nums[--j] > p) {

            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
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
        // 小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return new ArrayList<>(queue);
    }
}

