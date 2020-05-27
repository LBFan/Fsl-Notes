package leetcode.math;

/**
 * @author :  PF_23
 * @Description : 生成素数序列
 * 埃拉托斯特尼筛法在每次找到一个素数时，将能被素数整除的数排除掉。
 * 统计所有小于非负整数 n 的质数的数量。
 * 示例:
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * @date : 2020/02/25.
 */

public class Num01 {
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrimes[i]) {
                continue;
            }
            count++;
            // 从 i * i 开始，因为如果 k < i，那么 k * i 在之前就已经被去除过了
            for (long j = (long) i * i; j < n; j += i) {
                notPrimes[(int) j] = true;
            }
        }
        return count;
    }
}

