package leetcode.doublelink;

/**
 * @author :  PF_23
 * @Description : 两数平方和
 * <p>
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * @date : 2020/01/03.
 */

public class Num02 {
    public boolean judgeSquareSum(int target) {
        if (target < 0) {
            return false;
        }
        int lo = 0, hi = (int) Math.sqrt(target);
        while (lo <= hi) {
            int sum = lo * lo + hi * hi;
            if (sum == target) {
                return true;
            } else if (sum < target) {
                lo++;
            } else {
                hi--;
            }
        }
        return false;
    }
}

