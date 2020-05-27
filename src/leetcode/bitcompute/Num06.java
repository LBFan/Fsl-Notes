package leetcode.bitcompute;

/**
 * @author :  PF_23
 * @Description : 不用额外变量交换两个整数
 * @date : 2020/02/13.
 */

public class Num06 {
    private int[] swapNums(int x, int y) {
        x ^= y;
        y ^= x;
        x ^= y;
        int[] res = new int[2];
        res[0] = x;
        res[1] = y;
        return res;
    }
}

