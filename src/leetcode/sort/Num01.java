package leetcode.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author :  PF_23
 * @Description : Kth Element
 * 题目描述：找到倒数第 k 个的元素。也就是第K大元素
 * <p>
 * 排序 ：时间复杂度 O(NlogN)，空间复杂度 O(1)
 * @date : 2020/02/20.
 */

public class Num01 {
    /**
     * 使用Java库
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestMethod1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 堆 ：时间复杂度 O(NlogK)，空间复杂度 O(K)。
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestMethod2(int[] nums, int k) {
        // 小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int ele : nums) {
            pq.add(ele);
            // 维护堆的大小为K
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    /**
     * 快速选择 ：时间复杂度 O(N)，空间复杂度 O(1)
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestMethod3(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = k - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (nums[++i] < nums[l] && i < h) {

            }
            while (nums[--j] > nums[l] && j > l) {

            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

