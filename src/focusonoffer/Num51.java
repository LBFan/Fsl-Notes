package focusonoffer;

/**
 * @author :  PF_23
 * @Description : 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 思路：
 * 归并法
 * @date : 2019/12/31.
 */

public class Num51 {

    private long cnt = 0;
    /**
     * 在这里声明辅助数组，而不是在 merge() 递归函数中声明
     */
    private int[] tmp;

    public int InversePairs(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return (int) cnt % 1000000007;
    }

    private void mergeSort(int[] nums, int l, int h) {
        if (h - l < 1) {
            return;
        }
        int mid = l + (h - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, h);
        merge(nums, l, mid, h);
    }

    private void merge(int[] nums, int l, int m, int h) {
        int i = l, j = m + 1, k = l;
        while (i <= m || j <= h) {
            if (i > m) {
                tmp[k++] = nums[j++];
            } else if (j > h) {
                tmp[k++] = nums[i++];
            }else if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
                // 关键是理解这句话！！！TODO
                // num[i] > num[j] -> num[i]~num[m] 都大于num[j]
                cnt += m - i + 1;
            }
        }
        for (k = l; k <= h; k++) {
            tmp[k] = nums[k];
        }
    }
}

