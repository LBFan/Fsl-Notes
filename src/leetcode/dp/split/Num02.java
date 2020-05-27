package leetcode.dp.split;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description : 按平方数来分割整数
 * 题目描述：给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9
 * TODO:leetcode.search.bfs.Num02
 * @date : 2020/01/07.
 */

public class Num02 {

    public int numSquares(int n) {
        List<Integer> squareList = generateSquareList(n);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int square : squareList) {
                if (square > i) {
                    break;
                }
                min = Math.min(min, dp[i - square] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    /**
     * 从1开始生成连续的平方数集合
     *
     * @param n n
     * @return 集合
     */
    private List<Integer> generateSquareList(int n) {
        List<Integer> squareList = new ArrayList<>();
        int diff = 3;
        int square = 1;
        while (square <= n) {
            squareList.add(square);
            square += diff;
            diff += 2;
        }
        return squareList;
    }

    public static void main(String[] args) {
        int n = 13;
        int numSquares = new Num02().numSquares(n);
        System.out.println(numSquares);
    }
}

