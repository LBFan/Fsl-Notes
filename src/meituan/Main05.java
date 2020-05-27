package meituan;

import java.util.Scanner;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/03/26.
 * 套娃最近很流行，小美想知道前缀和是否也可以进行套娃操作。
 *
 *
 *
 * 小美现在想知道能否快速求解
 *
 * 输入
 * 第一行两个数N，K。
 *
 * 第二行N个数，第 i 个数为a[i]。
 *
 * 1<=N<=5000 ；1<=K<998244353；0<=a[i]<998244353
 *
 *
 *
 * 输出
 * 一个数表示sum[K][N]。
 *
 *
 * 样例输入
 * 4 3
 * 1 0 0 0
 * 样例输出
 * 10
 */

public class Main05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[][] sum = new int[k + 1][n];
        for (int i = 0; i < n; i++) {
            sum[0][i] = a[i];
        }
        for (int i = 1; i <= k; i++) {
            sum[i][0] = a[0];
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = (sum[i - 1][j] + sum[i][j - 1]);
            }
        }

        System.out.println(sum[k][n - 1]);
    }
}

