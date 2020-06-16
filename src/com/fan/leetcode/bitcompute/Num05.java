package com.fan.leetcode.bitcompute;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  PF_23
 * @Description : 翻转一个数的比特位
 * TODO
 * @date : 2020/02/13.
 */

public class Num05 {
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret <<= 1;
            ret |= (n & 1);
            n >>>= 1;
        }
        return ret;
    }

    /**
     * 如果该函数需要被调用很多次，可以将 int 拆成 4 个 byte，然后缓存 byte 对应的比特位翻转，最后再拼接起来。
     */
    private static Map<Byte, Integer> cache = new HashMap<>();

    public int reverseBitsByFunction(int n) {
        int ret = 0;
        for (int i = 0; i < 4; i++) {
            ret <<= 8;
            ret |= reverseByte((byte) (n & 0b11111111));
            n >>= 8;
        }
        return ret;
    }

    private int reverseByte(byte b) {
        if (cache.containsKey(b)) {
            return cache.get(b);
        }
        int ret = 0;
        byte t = b;
        for (int i = 0; i < 8; i++) {
            ret <<= 1;
            ret |= t & 1;
            t >>= 1;
        }
        cache.put(b, ret);
        return ret;
    }
}

