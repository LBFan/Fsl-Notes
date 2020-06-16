package com.fan.leetcode.bitcompute;

/**
 * @author :  PF_23
 * @Description : 统计两个数的二进制表示有多少位不同
 * @date : 2020/02/13.
 */

public class Num01 {
    public int hammingDistance(int x, int y) {
        int t = x ^ y;
        int count = 0;
        while (t != 0) {
            t &= (t - 1);
            count++;
        }
        return count;
    }
}

