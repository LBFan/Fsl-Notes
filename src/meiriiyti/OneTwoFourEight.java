package meiriiyti;

/**
 * @author :  PF_23
 * @Description :1248. 统计「优美子数组」
 * 给你一个整数数组 nums 和一个整数 k。
 * <p>
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * <p>
 * 请返回这个数组中「优美子数组」的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 * <p>
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 * <p>
 * 分析：
 * 1. 当数组中奇数个数 = k:
 * 总个数为 （最左边的奇数下标 + 1）x （数组长度 - 左右边的奇数下标）
 * 2. 当数组中奇数个数 > k 时：
 * 总和分为三段的和：
 * 第一段 ：包含最左边奇数：个数为
 * 3. 当数组中奇数个数 < k时 ：
 * 总数为0
 * @date : 2020/04/21.
 */

public class OneTwoFourEight {
    public static int numberOfSubarrays(int[] nums, int k) {
//        if (nums == null || nums.length == 0 || nums.length < k) {
//            return 0;
//        }
//        // 双指针
//        int left = 0, right = 0;
//        // 连续子数组中奇数的个数
//        int count = 0;
//        int res = 0;
//        // 记录第一个奇数前面的偶数个数
//        int preEven = 0;
//        while (right < nums.length) {
//            // 连续子数组中奇数个数不够
//            if (count < k) {
//                if (nums[right] % 2 != 0) {
//                    count++;
//                }
//                // 移动右侧指针
//                right++;
//            }
//            // 连续子数组中奇数个数够了，看第一个奇数前面有多少个偶数
//            if (count == k) {
//                preEven = 0;
//                while (count == k) {
//                    res++;
//                    if (nums[left] % 2 != 0) {
//                        count--;
//                    }
//                    left++;
//                    preEven++;
//                }
//            } else {
//                // 每次遇到 right 为偶数的时候就进行累加 相当于区间前面偶数个数 * 后面偶数个数
//                res += preEven;
//            }
//        }
//        return res;

        if (nums == null || nums.length == 0) {
            return -0;
        }
        int ans = 0, sum = 0;
        // map[i] ？？？
        int[] map = new int[nums.length + 1];
        map[0] = 1;
        for (int i : nums) {
            // 奇数个数
            sum += i & 1;
            map[sum]++;
            if (sum >= k) {
                ans += map[sum - k];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 2, 1, 2, 1, 2};
        int k = 2;
        int numberOfSubarrays = numberOfSubarrays(nums, k);
        System.out.println(numberOfSubarrays);
    }
}

