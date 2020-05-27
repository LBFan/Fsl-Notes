package focusonoffer;

/**
 * @author :  PF_23
 * @Description : 跳台阶
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 递归公式同10.2
 * @date : 2019/12/17.
 */

public class Num10Plus3 {
    public int JumpFloor(int n) {
        if (n <= 2) {
            return n;
        }
        int pre1 = 1, pre2 = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = pre1 + pre2;
            pre1 = pre2;
            pre2 = res;
        }
        return res;
    }
}

