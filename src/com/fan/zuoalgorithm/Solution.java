package com.fan.zuoalgorithm;

import java.util.Arrays;

class Solution {
    public int minIncrementForUnique(int[] A) {

        if (A == null || A.length == 0) {
            return 0;
        }
        int[] count = new int[80000];
        for (int x : A) {
            count[x]++;
        }

        int ans = 0, taken = 0;

        for (int x = 0; x < 80000; x++) {
            if (count[x] >= 2) {
                // x是重复数字
                taken += count[x] - 1;
                ans -= (x * (count[x] - 1));
            } else if (count[x] == 0) {
                // x未出现过
                taken--;
                ans += x;
            }
        }
        return ans;
    }

    public int minIncrementForUnique2(int[] A) {

        Arrays.sort(A);
        int ans = 0, taken = 0;
        for (int i = 1; i < A.length; ++i) {
            if (A[i - 1] == A[i]) {
                // 如果 A[i - 1] == A[i]，我们将操作次数减去 A[i]，并将重复的数的个数增加 1
                taken++;
                ans -= A[i];
            } else {
                // 如果 A[i - 1] < A[i]，则区间 [A[i−1]+1,A[i]−1] 里的数都是没有出现过的，
                // 所以我们可以将之前重复的数变为这个区间范围内的数。
                // 设当前重复的数的个数为 taken，
                // 则我们最多可以改变 give = min(taken, A[i] - A[i - 1] - 1) 个数，
                // 即区间 [A[i−1]+1,A[i]−1] 的长度与 taken 二者的较小值。它们的操作数对答案的贡献为：
                // [A[i−1]+1,A[i]−1]数组的和，等差数列求和
                int give = Math.min(taken, A[i] - A[i - 1] - 1);
                taken -= give;
                ans += give * (give + 1) / 2 + give * A[i - 1];
            }
        }
        // 在扫描完数组后，如果仍然有重复的数，即 taken 不为 0，我们可以将这些数变为区间
        // [A[n−1]+1,∞) 中的数，其中 A[n - 1] 是数组 A 中的最后一个数
        if (taken > 0) {
            ans += taken * (taken + 1) / 2 + taken * A[A.length - 1];
        }
        return ans;
    }
}