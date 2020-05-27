package ctrip;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author :  PF_23
 * @Description :携程海洋馆的海豚小宝宝
 * 携程海洋馆中有 n 只萌萌的小海豚，初始均为 0 岁，每只小海豚的寿命是 m 岁，
 * <p>
 * 且这些小海豚会在 birthYear[i] 这些年份生产出一位宝宝海豚（1 <= birthYear[i] <= m），每位宝宝海豚刚出生为 0 岁。
 * <p>
 * 问 x 年时，携程海洋馆有多少只小海豚？
 * <p>
 * n（初始海豚数）
 * <p>
 * m（海豚寿命）
 * <p>
 * 海豚生宝宝的年份数量(假设为p)
 * <p>
 * 海豚生宝宝的年份1
 * <p>
 * ...
 * <p>
 * 海豚生宝宝的年份p
 * <p>
 * x（几年后）
 * 输出
 * x年后，共有多少只小海豚
 * <p>
 * <p>
 * 样例输入
 * 5
 * 5
 * 2
 * 2
 * 4
 * 5
 * 样例输出
 * 20
 * @date : 2020/04/01.
 */

public class Main02 {

    static long countDolphin(int n, int m, int[] birthYear, int x) {
        int[] dp = new int[x + 1];
        dp[1] = n;
        int sum = 0;
        // 找出哪些年份会生小海豚
        List<Integer> years = new ArrayList<>();
        for (int i = 0; i < birthYear.length; i++) {
            years.add(birthYear[i]);
        }
        int star = years.get(0);
        // 生小海豚前star年数量均不会变
        for (int i = 2; i < star; i++) {
            dp[i] = n;
            sum += dp[i];
        }

        for (int i = star; i <= x; i++) {
            if (years.contains(i % m)) {
                sum = sum + dp[i % m - star + 1];
                dp[i] = sum + 1;
            } else if (i <= m) {
                dp[i] = dp[i - star + 1] + 1;
            } else { // 母牛死了，不再加1
                dp[i] = dp[i - m - 1];
            }
        }
        return dp[x];

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long res;

        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        int _birthYear_size;
        _birthYear_size = Integer.parseInt(in.nextLine().trim());
        int[] _birthYear = new int[_birthYear_size];
        int _birthYear_item;
        for (int _birthYear_i = 0; _birthYear_i < _birthYear_size; _birthYear_i++) {
            _birthYear_item = Integer.parseInt(in.nextLine().trim());
            _birthYear[_birthYear_i] = _birthYear_item;
        }

        int _x;
        _x = Integer.parseInt(in.nextLine().trim());

        res = countDolphin(_n, _m, _birthYear, _x);
        System.out.println(res);


    }
}

