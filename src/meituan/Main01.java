package meituan;

import java.util.Scanner;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/03/26.
 * 首先给出你一个整数，可能为正也可能为负，这个数字中仅包含数字1-9，现在定义一个1-9的置换，
 * 即指定将整数中的某个数字按顺序变换为另一个数字，请你输出变换以后的数字是多少。
 * <p>
 * 输入第一行包含一个整数a。(-10^1000<=a<=10^1000)
 * <p>
 * 输入第二行包含9个以空格隔开的整数a_i , 第i个整数表示将数字i替换为数字a_i。(1<=a_i<=9)
 * <p>
 * 请你输出数字变换之后的结果。
 * <p>
 * 样例输入
 * 1234567
 * 9 8 7 6 5 4 3 2 1
 * 样例输出
 * 9876543
 * <p>
 * 输入样例2
 * -12
 * 2 3 7 6 5 4 3 2 1
 * <p>
 * 输出样例2
 * -23
 */

public class Main01 {

    public static void main01(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int[] a = new int[9];
        for (int i = 0; i < 9; i++) {
            a[i] = sc.nextInt();
        }

        boolean isNegative = n <= 0;
        long tmp;
        if (isNegative) {
            tmp = -n;
        } else {
            tmp = n;
        }
        int cnt = 0;
        while (tmp != 0) {
            tmp /= 10;
            cnt++;
        }
        tmp = isNegative ? -n : n;
        int[] num = new int[cnt];
        for (int i = cnt - 1; i >= 0; i--) {
            num[i] = (int) (tmp % 10);
            tmp /= 10;
        }

        int[] res = new int[num.length];

        for (int i = 0; i < num.length; i++) {
            // 输入第二行包含9个以空格隔开的整数a_i , 第i个整数表示将数字i替换为数字a_i
            res[i] = a[num[i] - 1];
        }

        long ans = 0;
        for (int i = 0; i < res.length; i++) {
            ans = ans * 10 + res[i];
        }
        System.out.println(isNegative ? -ans : ans);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        char[] a = x.toCharArray();
        int[] nums = new int[9];
        for (int i = 0; i < 9; i++) {
            nums[i] = sc.nextInt();
        }
        int n = x.length();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < n; j++) {
                if (x.charAt(j) - 48 == i + 1) {
                    a[j] = (char) (nums[i] + 48);
                }
            }
        }
        System.out.println(a);
    }
}

