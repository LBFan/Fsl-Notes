package meiriiyti;

/**
 * @author : PF_23
 * @Description :搜索旋转数组
 * @date : 2020/04/27.
 */

public class ThirtyThree {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int le = 0, ri = nums.length - 1;
        while (le <= ri) {
            int mid = le + (ri - le) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            // 前半部分有序
            if (nums[le] <= nums[mid]) {
                if (target >= nums[le] && target < nums[mid]) {
                    ri = mid - 1;
                } else {
                    le = mid + 1;
                }
            } else {
                if (target <= nums[ri] && target > nums[mid]) {
                    le = mid + 1;
                } else {
                    ri = mid - 1;
                }
            }
        }
        return -1;
    }
}

