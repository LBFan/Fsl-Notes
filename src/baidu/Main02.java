package baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/03/29.
 */

public class Main02 {
    private static long k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 第一行数字n
        int n = sc.nextInt();
        // 小于10的18次方，用long类型
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        // 排序
        Arrays.sort(arr);
        long lessN = tillLessN(arr);
        System.out.println(lessN);

    }

    private static long tillLessN(long[] nums) {
        int n = nums.length;
        if (nums[n - 1] < n) {
            return k;
        }
        nums[n - 1] -= n;
        for (int i = 0; i < n - 1; i++) {
            nums[i]++;
        }
        Arrays.sort(nums);
        return tillLessN(nums) + 1;
    }
}

