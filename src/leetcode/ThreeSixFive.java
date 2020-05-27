package leetcode;

/**
 * @author : PF_23
 * @Description : 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * <p>
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * <p>
 * 你允许：
 * <p>
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * <p>
 * 示例 1: (From the famous "Die Hard" example)
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * <p>
 * 示例 2:
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 * @date : 2020/04/25.
 */

public class ThreeSixFive {
    /**
     * 贝祖定理告诉我们，ax+by=z 有解当且仅当 z是 x, y 的最大公约数的倍数。
     * 因此我们只需要找到 x, y 的最大公约数并判断 z 是否是它的倍数即可。
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if ((x + y) < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return (z == 0) || ((x + y) == z);
        }
        // 求x和y的最大公约数
        int t = gcb(x, y);
        // z是否是其最大的公约数的倍数，是则返回true，否则返回false；
        return z % t == 0;
    }

    private int gcb(int a, int b) {
        return b == 0 ? a : gcb(b, a % b);
    }
}

