package leetcode.bitcompute;

/**
 * @author :  PF_23
 * @Description : 判断一个数是不是 4 的 n 次方
 * @date : 2020/02/13.
 */

public class Num08 {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0b01010101010101010101010101010101) != 0;
    }
}

