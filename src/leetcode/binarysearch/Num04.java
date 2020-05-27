package leetcode.binarysearch;

/**
 * @author :  PF_23
 * @Description :  第一个错误的版本
 * 题目描述：给定一个元素 n 代表有 [1, 2, ..., n] 版本，在第 x 位置开始出现错误版本，导致后面的版本都错误。
 * 可以调用 isBadVersion(int x) 知道某个版本是否错误，要求找到第一个错误的版本。
 * @date : 2020/02/09.
 */

public class Num04 {
    public int firstBadVersion(int n) {
        int l = 1, h = n;
        while (l < h) {
            int mid = (l + h) >>> 1;
            if (isBadVersion(mid)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    boolean isBadVersion(int version){
        if (version > 6) {
            return true;
        }
        return false;
    }
}

