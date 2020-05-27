package focusonoffer;

/**
 * @author :  PF_23
 * @Description : 不修改数组找出重复的数字
 * 找出数组中任意一个重复的数字,在长度为n + 1的数组里所有数字都在1~n的范围内。
 * <p>
 * 思路：
 * 不能修改数组，所以不能使用交换
 * 在不使用额外空间的条件下，如何解决
 * <p>
 * 考点：
 * 对一维数组的理解及编程能力
 * 对二分查找的理解
 * 沟通能力
 * @date : 2020/04/22.
 */

public class Num03Plus {
    public static int getDuplication(int[] nums, int length) {
        if (nums == null || length <= 0) {
            return -1;
        }
        int start = 0, end = length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int count = countRange(nums, length, start, mid);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;

    }

    private static int countRange(int[] nums, int length, int start, int end) {
        if (nums == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] >= start + 1 && nums[i] <= end + 1) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        int n = nums.length;
        int duplication = getDuplication(nums, n);
        System.out.println(duplication);
    }
}

