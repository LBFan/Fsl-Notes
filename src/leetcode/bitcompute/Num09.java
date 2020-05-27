package leetcode.bitcompute;

/**
 * @author :  PF_23
 * @Description : 判断一个数的位级表示是否不会出现连续的 0 和 1
 * 对于 1010 这种位级表示的数，把它向右移动 1 位得到 101，这两个数每个位都不同，因此异或得到的结果为 1111。
 * @date : 2020/02/13.
 */

public class Num09 {
    public boolean hasAlternatingBits(int n) {
        int res = (n ^ (n >> 1));
        return (res & (res + 1)) == 0;
    }
}

