package focusonoffer;

/**
 * @author :  PF_23
 * @Description : 圆圈中最后剩下的数 约瑟夫环
 * 让小朋友们围成一个大圈。
 * 然后，随机指定一个数 m，让编号为 0 的小朋友开始报数。
 * 每次喊到 m-1 的那个小朋友要出列唱首歌，然后可以在礼品箱中任意的挑选礼物，并且不再回到圈中，
 * 从他的下一个小朋友开始，继续 0...m-1 报数 .... 这样下去 .... 直到剩下最后一个小朋友，可以不用表演。
 * <p>
 * 思路：
 * 约瑟夫环，圆圈长度为 n 的解可以看成长度为 n-1 的解再加上报数的长度 m。因为是圆圈，所以最后需要对 n 取余。
 * @date : 2019/12/31.
 */

public class Num62 {
    public int LastRemaining_Solution(int n, int m) {
//        /* 特殊输入的处理 */
//        if (n == 0) {
//            return -1;
//        }
//        if (n == 1) {
//            return 0;
//        }
//        /* 递归返回条件!!! TODO记住公式 */
//        return (LastRemaining_Solution(n - 1, m) + m) % n;

        int dp1 = 1;
        for (int i = 2; i <= n; i++) {
            int removeNum = m % i;
            //剩下的要留下来的
            dp1 = removeNum + dp1;
            if (dp1 > i) {
                dp1 = dp1 - i;
            }


        }
        return dp1 - 1;
    }
}

