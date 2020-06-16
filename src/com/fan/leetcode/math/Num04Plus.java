package com.fan.leetcode.math;

/**
 * @author :  PF_23
 * @Description : 16 进制
 * Input:
 * 26
 * <p>
 * Output:
 * "1a"
 * <p>
 * Input:
 * -1
 * <p>
 * Output:
 * "ffffffff"
 * 负数要用它的补码形式。
 * @date : 2020/02/25.
 */

public class Num04Plus {
    public String toHex(int num) {
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if (num == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        while(num != 0) {
            sb.append(map[num & 0b1111]);
            // 因为考虑的是补码形式，因此符号位就不能有特殊的意义，需要使用无符号右移，左边填 0
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}

