package sort.merge;

import java.util.Comparator;

/**
 * @author :  PF_23
 * @Description : 自顶向下归并排序
 * 将一个大数组分成两个小数组去求解。
 * <p>
 * 因为每次都将问题对半分成两个子问题，这种对半分的算法复杂度一般为 O(NlogN)。
 * @date : 2019/11/29.
 */

public class Up2DownMergeSort<T extends Comparable<T>> extends MergeSort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        aux = (T[]) new Comparator[N];
        sort(nums, 0, N - 1);
    }

    private void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int mid = (l + h) >>> 1;
        sort(nums, l, mid);
        sort(nums, mid + 1, h);
        merge(nums, l, mid, h);
    }
}

