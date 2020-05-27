package focusonoffer;

/**
 * @author :  PF_23
 * @Description : 数值的整数次方
 * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方。
 * 因为 (x*x)n/2 可以通过递归求解，并且每次递归 n 都减小一半，因此整个算法的时间复杂度为 O(logN)
 * @date : 2019/12/18.
 */

public class Num16 {
    public static double Power(double base, int exponent) {
        // 注意边界,正负数
        if (exponent == 1) {
            return base;
        }
        if (exponent == 0) {
            return 1;
        }

        boolean isNegative = (base > 0);
        double res = Power(base * base, exponent >> 1);
        if (exponent % 2 == 1) {
            res *= base;
        }
        return isNegative ? 1 / res : res;
    }

    public static void main(String[] args) {
        double base = 2.3d;
        int exponent = 7;
        double power = Power(base, exponent);
        System.out.println(power);
    }
}

