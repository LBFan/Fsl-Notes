package hanshunping.datastructrue.sort;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 选择排序
 * 第一次从 arr[0]~arr[n-1]中选取最小值，
 * 与 arr[0]交换，第二次从 arr[1]~arr[n-1]中选取最小值，与 arr[1]交换，第三次从 arr[2]~arr[n-1]中选取最小值，
 * 与 arr[2] 交换，...，第 i 次从 arr[i-1]~arr[n-1]中选取最小值，与 arr[i-1]交换，...,
 * 第 n-1 次从 arr[n-2]~arr[n-1]中选取最小值， 与 arr[n-2]交换，总共通过 n-1 次，
 * 得到一个按排序码从小到大排列的有序序列
 * @date : 2020/03/17.
 */

public class SelectSort {
    public static void selectSort(int[] arr) {
        // 表示需要进行arr.length - 1趟排序
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 5, 7, 4, 9};
        SelectSort.selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

