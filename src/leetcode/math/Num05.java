package leetcode.math;

/**
 * @author :  PF_23
 * @Description : 统计阶乘尾部有多少个 0
 * 尾部的 0 由 2 * 5 得来，2 的数量明显多于 5 的数量，因此只要统计有多少个 5 即可。
 * <p>
 * 对于一个数 N，它所包含 5 的个数为：N/5 + N/52 + N/53 + ...，其中 N/5 表示不大于 N 的数中 5 的倍数贡献一个 5，N/52 表示不大于 N 的数中 52 的倍数再贡献一个 5 ...。
 * @date : 2020/02/25.
 */

public class Num05 {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}

