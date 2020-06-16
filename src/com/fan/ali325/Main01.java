package com.fan.ali325;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/03/26.
 * <p>
 * 给定一个数字n，然后给三个长度为n的数组，可以从这三个数组中选出一个长度为n的数组，第i个位置需要是从给出的三个数组第i个位置选择的，
 * 然后要求使这个数组后一项减前一项的绝对值之和最小。
 * 输入示例：：
 * 5 9  5 4  4
 * 4 7  4 10 3
 * 2 10 9 2  3
 * 这里可以选择5 7 5 4 4，所以输出等于|7-5|+|5-7|+|4-5|+|4-4|=5。所以输出就是5。
 * <p>
 * 这个问题可以看成是在矩阵中寻找一个路径，要求整个路径的前向之差绝对值最小。可以想如何把问题规模缩小，显然下一个数的选择，可以有三条路径，如果从第一行过来，那么就需要用到选了第一行的路径的和的最小值，同样也需要求出用到第二行和第三行过来的路径的最小值。
 *   可见这是一个动态规划问题。我们定义一个动态规划数组，dp_{ij}
 * ​
 * 表示选择了矩阵中(i,j)位置的元素，最小的路径绝对值之和。显然最终的结果就是最后一列三个路径最小值。
 * dp_{ij}=min(abs(A[i][j]-A[i-1][k])+dp_{i-1,k}) k∈{0,1,2}
 */

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        int res = Integer.MAX_VALUE;
        int[][] arr = new int[3][N];
        int[][] dp = new int[3][2];
        // 构造输入数组
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 3; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0] = 0;
        }
        for (int j = 1; j < N; j++) {
            for (int i = 0; i < 3; i++) {
                dp[i][j % 2] = Math.min(dp[i][j % 2], Math.abs(arr[i][j] - arr[0][j - 1]) + dp[0][(j + 1) % 2]);
                dp[i][j % 2] = Math.min(dp[i][j % 2], Math.abs(arr[i][j] - arr[1][j - 1]) + dp[1][(j + 1) % 2]);
                dp[i][j % 2] = Math.min(dp[i][j % 2], Math.abs(arr[i][j] - arr[2][j - 1]) + dp[2][(j + 1) % 2]);
            }
            dp[0][(j + 1) % 2] = Integer.MAX_VALUE;
            dp[1][(j + 1) % 2] = Integer.MAX_VALUE;
            dp[2][(j + 1) % 2] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < 3; i++) {
            res = Math.min(res, dp[i][(N + 1) % 2]);
        }
        System.out.println(res);

    }

}

