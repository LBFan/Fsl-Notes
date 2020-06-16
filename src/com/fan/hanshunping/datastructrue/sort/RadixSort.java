package com.fan.hanshunping.datastructrue.sort;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 基数排序
 * 将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。
 * 这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
 * 最高位有多少位数字，就需要排序多少趟
 * 例如 最大数字为548，是一个三位数，那么需要进行三趟排序即可以成为一个有序序列
 * <p>
 * 1) 基数排序是对传统桶排序的扩展，速度很快.
 * 2) 基数排序是经典的空间换时间的方式，占用内存很大, 当对海量数据排序时，容易造成 OutOfMemoryError 。
 * 3) 基数排序时稳定的。[注:假定在待排序的记录序列中，存在多个具有相同的关键字的记录，若经过排序，这些
 * 记录的相对次序保持不变，即在原序列中，r[i]=r[j]，且 r[i]在 r[j]之前，而在排序后的序列中，r[i]仍在 r[j]之前，
 * 则称这种排序算法是稳定的;否则称为不稳定的]
 * 4) 有负数的数组，我们不用基数排序来进行排序, 如果要支持负数，参考: https://code.i-harness.com/zh-CN/q/e98fa9
 * @date : 2020/04/15.
 */

public class RadixSort {

    public static void radixSort(int[] arr) {
        //1. 得到数组中最大的数的位数
        //假设第一数就是最大数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = max < arr[i] ? arr[i] : max;
        }

        // 得到最大数是几位数
        int maxLength = (max + "").length();

        //定义一个二维数组，表示 10 个桶, 每个桶就是一个一维数组
        //说明
        //1. 二维数组包含 10 个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为 arr.length
        // 3. 名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数 可以这里理解
        //比如:bucketElementCounts[0] , 记录的就是 bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];

        // 从个位开始每一趟排序
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //(针对每个元素的对应位进行排序处理)， 第一次是个位，第二次是十位，第三次是百位..
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的对应位的值
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组
            int index = 0;
            //遍历每一桶，并将桶中是数据，放入到原数组 
            for (int j = 0; j < bucketElementCounts.length; j++) {
                //如果桶中，有数据，我们才放入到原数组
                if (bucketElementCounts[j] != 0) {
                    //循环该桶即第 j 个桶(即第 j 个一维数组), 放入
                    for (int l = 0; l < bucketElementCounts[j]; l++) {
                        //取出元素放入到 arr
                        arr[index++] = bucket[j][l];
                    }
                }
                //第 i+1 轮处理后，需要将每个 bucketElementCounts[j] = 0 !!!! 因为下一轮还需要使用
                bucketElementCounts[j] = 0;
            }
            //System.out.println("第"+(i+1)+"轮，对个位的排序处理 arr =" + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

