package leetcode.binarysearch;

/**
 * @author :  PF_23
 * @Description : 求开方
 * Input: 4
 * Output: 2
 * <p>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842...,
 * and since we want to return an integer, the decimal part will be truncated.
 * @date : 2020/02/09.
 */

public class Num01 {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int low = 1, hi = x;
        while (low <= hi) {
            // int mid = low + (hi - low) / 2;
            int mid = (hi + low) >>> 1;
            int sqrt = x / mid;
            if (mid > sqrt) {
                hi = mid - 1;
            } else if (mid < sqrt) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return hi;
    }

    public static void main(String[] args) {
        int n = 8;
        int mySqrt = new Num01().mySqrt(n);
        System.out.println(mySqrt);
    }
}

