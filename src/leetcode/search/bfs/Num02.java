package leetcode.search.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author :  PF_23
 * @Description : 组成整数的最小平方数数量
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 * <p>
 * 可以将每个整数看成图中的一个节点，如果两个整数之差为一个平方数，那么这两个整数所在的节点就有一条边。
 * 要求解最小的平方数数量，就是求解从节点 n 到节点 0 的最短路径。
 * 本题也可以用动态规划求解，在之后动态规划部分中会再次出现。
 * @date : 2020/02/21.
 */

public class Num02 {
    /**
     * BFS
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                Integer cur = queue.poll();
                int next = n - cur;
                for (int s : squares) {
                    if (next < 0) {
                        break;
                    }
                    if (next == 0) {
                        return level;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return n;
    }

    /**
     * DP
     *
     * @param n
     * @return
     */
    public int numSquaresByDp(int n) {
        List<Integer> squares = generateSquares(n);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int square : squares) {
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
     * 生成小于 n 的平方数序列
     *
     * @param n
     * @return
     */
    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }

    public static void main(String[] args) {
        int n = 13;
        int numSquares = new Num02().numSquares(n);
        System.out.println(numSquares);
    }
}

