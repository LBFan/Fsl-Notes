package hanshunping.datastructrue.sort;


import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 冒泡排序
 * 通过对待排序序列从前向后(从下标较小的元素开始),依次比较 相邻元素的值，若发现逆序则交换，使值较大的元素逐渐从前移向后部，
 * 就象水底下的气泡一样逐渐向上冒
 * <p>
 * 优化:
 * 因为排序的过程中，各元素不断接近自己的位置，如果一趟比较下来没有进行过交换，就说明序列有序，
 * 因此要在 排序过程中设置一个标志 flag 判断元素是否进行过交换。从而减少不必要的比较。
 * @date : 2020/03/17.
 */

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 5, 6, 7};
        BubbleSort.bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort(int[] arr) {
        // 标识变量， 表示是否进行过交换
        boolean flag = false;
        for (int i = 0; i < arr.length - 1 && !flag; ++i) {
            /// 重要！！！ 每一趟开始时都假定会发生交换
            flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换
                    flag = false;
                    SwapUtil.swap(arr, j, j + 1);
                }
            }
        }

    }

}

