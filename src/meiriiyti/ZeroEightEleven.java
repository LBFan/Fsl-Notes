package meiriiyti;

/**
 * @author : PF_23
 * @Description : 数组中的逆序对
 * @date : 2020/04/25.
 */

public class ZeroEightEleven {
    long cnt = 0;

    int[] tmp;


    /**
     * 分治思想
     *
     * @param nums 数组
     * @return 逆序对
     */
    public int reversePairs(int[] nums) {
        tmp = new int[nums.length];
        // 归并排序
        mergeSort(nums, 0, nums.length - 1);
        return (int) cnt;
    }

    private void mergeSort(int[] nums, int l, int h) {
        if (l >= h) {
            return;
        } else {
            int mid = l + (h - l) / 2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, h);
            merge(nums, l, mid, h);
        }
    }

    private void merge(int[] nums, int l, int m, int h) {
        int i = l, j = m + 1, k = l;
        while (i <= m || j <= h) {
            if (i > m) {
                tmp[k++] = nums[j++];
            } else if (j > h) {
                tmp[k++] = nums[i++];
            } else if (nums[j] >= nums[i]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
                // nums[i] > nums[j] -> 有序数组从i~m的值都大于nums[j]:与nums[j]组成逆序对个数为 m - i + 1 个
                cnt += m - i + 1;
            }
        }
        for (k = l; k <= h; k++) {
            nums[k] = tmp[k];
        }

    }
}

