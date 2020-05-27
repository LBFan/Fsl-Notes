package leetcode.arrs;

/**
 * @author :  PF_23
 * @Description : 一个数组元素在 [1, n] 之间，其中一个数被替换为另一个数，找出重复的数和丢失的数
 * 最直接的方法是先对数组进行排序，这种方法时间复杂度为 O(NlogN)。本题可以以 O(N) 的时间复杂度、O(1) 空间复杂度来求解。
 *
 * 主要思想是通过交换数组元素，使得数组上的元素在正确的位置上。
 * @date : 2020/02/25.
 */

public class Num06 {
    public int[] findErrorNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return null;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

