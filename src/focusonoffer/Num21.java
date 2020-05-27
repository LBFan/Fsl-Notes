package focusonoffer;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

/**
 * @author :  PF_23
 * @Description :调整数组顺序使奇数位于偶数前面
 * 需要保证奇数和奇数，偶数和偶数之间的相对位置不变
 * 方法一：创建一个新数组，时间复杂度 O(N)，空间复杂度 O(N)。
 * 方法二：使用冒泡思想，每次都当前偶数上浮到当前最右边。时间复杂度 O(N²)，空间复杂度 O(1)，时间换空间。
 * @date : 2019/12/23.
 */

public class Num21 {
    /**
     * 1：常规解法
     *
     * @param nums
     */
    public void reOrderArray(int[] nums) {
        // 奇数个数
        int oddCnt = 0;
        for (int el : nums) {
            if (!isEven(el)) {
                oddCnt++;
            }
        }
        int[] copy = nums.clone();
        int i = 0;
        int j = oddCnt;
        for (int n : copy) {
            if (isEven(n)) {
                nums[j++] = n;
            } else {
                nums[i++] = n;
            }
        }
    }

    /**
     * 是否是偶数
     *
     * @param el
     * @return
     */
    private boolean isEven(int el) {
        return el % 2 == 0;
    }

    /**
     * 2：冒泡法
     *
     * @param nums
     */
    public void reOrderArrayWithBubble(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (isEven(nums[j]) && !isEven(nums[j + 1])) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] nums, int j, int i) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}

