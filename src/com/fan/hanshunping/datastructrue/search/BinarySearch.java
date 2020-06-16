package com.fan.hanshunping.datastructrue.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description : 二分查找
 * 注意:使用二分查找的前提是 该数组是有序的
 * @date : 2020/04/15.
 */

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1234};
        int index = binarySearch(arr, 0, arr.length - 1, 89);
        System.out.println(index);
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        // 当 left > right 时，说明递归整个数组，但是没有找到
        int l = left, r = right;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == findVal) {
                return mid;
            } else if (arr[mid] > findVal) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        // 向 右递归
        if (findVal > midVal) {
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            // 向左递归
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            //思路分析
            // * 1. 在找到 mid 索引值，不要马上返回
            // * 2. 向 mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合 ArrayList
            // * 3. 向 mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合 ArrayList
            // * 4. 将 Arraylist 返回
            List<Integer> resIndexlist = new ArrayList<>();
            //向 mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合 ArrayList
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resIndexlist.add(temp--);
            }
            resIndexlist.add(mid);
            //向 mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合 ArrayList
            temp = mid + 1;
            while (true) {
                if (temp > arr.length || arr[temp] != findVal) {
                    break;
                }
                resIndexlist.add(temp++);
            }
            return resIndexlist;
        }
    }
}

