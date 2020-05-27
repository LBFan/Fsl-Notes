package leetcode.math;

/**
 * @author :  PF_23
 * @Description : 改变数组元素使所有的数组元素都相等
 * Input:
 * [1,2,3]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * 每次可以对一个数组元素加一或者减一，求最小的改变次数。
 * <p>
 * 这是个典型的相遇问题，移动距离最小的方式是所有元素都移动到中位数。理由如下：
 * 设 m 为中位数。a 和 b 是 m 两边的两个元素，且 b > a。要使 a 和 b 相等，它们总共移动的次数为 b - a，这个值等于 (b - m) + (m - a)，也就是把这两个数移动到中位数的移动次数。
 * 设数组长度为 N，则可以找到 N/2 对 a 和 b 的组合，使它们都移动到 m 的位置。
 * @date : 2020/02/25.
 */

public class Num08 {
    /**
     * 解法 1
     * 先排序，时间复杂度：O(NlogN)
     *
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int move = 0;
        while (lo <= hi) {
            move += nums[hi--] - nums[lo++];
        }
        return move;
    }

    /**
     * 使用快速选择找到中位数，时间复杂度 O(N)
     *
     * @param nums
     * @return
     */
    public int minMove2Method2(int[] nums) {
        int move = 0;
        int median = findKthSmallest(nums, nums.length / 2);
        for (int num :
                nums) {
            move += Math.abs(num - median);
        }
        return move;
    }

    private int findKthSmallest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int start, int end) {
        int i = start, j = end + 1;
        while (true) {
            while (nums[++i] < nums[start] && i < end) {

            }
            while (nums[--j] > nums[end] && j > start) {

            }
            if (i > j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

