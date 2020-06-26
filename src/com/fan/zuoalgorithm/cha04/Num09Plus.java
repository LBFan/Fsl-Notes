package com.fan.zuoalgorithm.cha04;

/**
 * @author :  PF_23
 * @Description : 进阶问题
 * @date : 2020/03/21.
 */

public class Num09Plus {
    public int step1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        return proess(arr, arr.length - 1, 1, 2, 3);
    }

    private int proess(int[] arr, int i, int from, int mid, int to) {
        if (i == -1) {
            return 0;
        }
        if (arr[i] != from && arr[i] != to) {
            return -1;
        }
        // 第i个在from上面
        if (arr[i] == from) {
            return proess(arr, i - 1, from, to, mid);
        } else {
            // 第i个在to上面
            int rest = proess(arr, i - 1, from, to, mid);
            if (rest == -1) {
                return -1;
            }
            return (1 << i) + rest;
        }
    }

    /**
     * 非递归方法
     *
     * @param arr
     * @return
     */
    public int step2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int from = 1, mid = 2, to = 3;
        int i = arr.length - 1;
        int res = 0;
        int tmp;
        while (i >= 0) {
            if (arr[i] != from && arr[i] != to) {
                return -1;
            }
            if (arr[i] == from) {
                tmp = to;
                to = mid;
            } else {
                res += 1 << i;
                tmp = from;
                from = mid;
            }
            mid = tmp;
            --i;
        }
        return res;
    }
}

