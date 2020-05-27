package leetcode.bitcompute;

/**
 * @author :  PF_23
 * @Description : 判断一个数是不是 2 的 n 次方. 二进制表示只有一个 1 存在。
 * @date : 2020/02/13.
 */

public class Num07 {
    public boolean isPowerOfTwo(int n) {
//        return n > 0 && Integer.bitCount(n) == 1;
        return n > 0 && (n & (n - 1)) == 0;
    }
}

