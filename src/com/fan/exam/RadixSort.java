package com.fan.exam;

/**
 * @Description : 基数排序
 * @Author : shulin.fan
 * @Date : 2020/7/9
 */
public class RadixSort {
    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int a : arr) {
            max = a > max ? a : max;
        }

        int maxLen = (max + "").length();
        int[][] bucket = new int[10][maxLen];
        int[] bucketElementCount = new int[10];
        for (int i = 0, n = 1; i < maxLen; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
                bucketElementCount[digitOfElement]++;
            }

            int index = 0;

            for (int j = 0; j < bucketElementCount.length; j++) {
                if (bucketElementCount[j] != 0) {
                    // 当前桶存在数据
                    for (int k = 0; k < bucketElementCount[j]; k++) {
                        arr[index++] = bucket[j][k];
                    }
                }
                bucketElementCount[j] = 0;
            }
        }
    }
}
