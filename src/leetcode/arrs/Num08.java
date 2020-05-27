package leetcode.arrs;

/**
 * @author :  PF_23
 * @Description : 数组相邻差值的个数
 * 题目描述：数组元素为 1~n 的整数，要求构建数组，使得相邻元素的差值不相同的个数为 k。
 * Input: n = 3, k = 2
 * Output: [1, 3, 2]
 * Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3,
 * and the [2, 1] has exactly 2 distinct integers: 1 and 2.
 * 让前 k+1 个元素构建出 k 个不相同的差值，序列为：1 k+1 2 k 3 k-1 ... k/2 k/2+1.
 * @date : 2020/02/26.
 */

public class Num08 {
    private int[] constructArray(int n, int k) {
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1, interval = k; i <= k; i++, interval--) {
            res[i] = (i % 2 == 1) ? res[i - 1] + interval : res[i - 1] - interval;
        }

        for (int i = k + 1; i < n; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}

