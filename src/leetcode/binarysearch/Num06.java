package leetcode.binarysearch;

/**
 * @author :  PF_23
 * @Description : 查找区间
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * <p>
 * 在寻找第一个位置的二分查找代码中，需要注意 h 的取值为 nums.length，而不是 nums.length - 1。先看以下示例：
 * <p>
 * nums = [2,2], target = 2
 * 如果 h 的取值为 nums.length - 1，那么 last = findFirst(nums, target + 1) - 1 = 1 - 1 = 0。
 * 这是因为 findLeft 只会返回 [0, nums.length - 1] 范围的值，对于 findFirst([2,2], 3) ，
 * 我们希望返回 3 插入 nums 中的位置，也就是数组最后一个位置再往后一个位置，即 nums.length。
 * 所以我们需要将 h 取值为 nums.length，从而使得 findFirst返回的区间更大，能够覆盖 target 大于 nums 最后一个元素的情况。
 * @date : 2020/02/09.
 */

public class Num06 {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findFirst(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first, Math.max(first, last)};
        }
    }

    private int findFirst(int[] nums, int target) {
//        int l = 0, h = nums.length - 1;
//        while (l <= h) {
//            int mid = (l + h) >>> 1;
//            if (nums[mid] == i) {
//                return mid;
//            } else if (nums[mid] > i) {
//                h = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return -1;

        // 注意 h 的初始值
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= target) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int[] searchRange = new Num06().searchRange(nums1, 8);
        int[] searchRange02 = new Num06().searchRange(nums1, 6);
    }
}

