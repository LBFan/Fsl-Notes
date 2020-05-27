package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  PF_23
 * @Description : 最长连续序列
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 要求以 O(N) 的时间复杂度求解
 * @date : 2020/02/16.
 */

public class Num04 {
    private int longestConsecutive(int[] nums) {
        Map<Integer, Integer> countForNum = new HashMap<>();
        for (int num : nums) {
            countForNum.put(num, 1);
        }
        for (int num : nums) {
            forward(countForNum, num);
        }
        return maxCount(countForNum);
    }

    private int maxCount(Map<Integer, Integer> countForNum) {
        int max = 0;
        for (int num : countForNum.keySet()) {
            max = Math.max(max, countForNum.get(num));
        }
        return max;
    }

    private int forward(Map<Integer, Integer> countForNum, int num) {
        if (!countForNum.containsKey(num)) {
            return 0;
        }
        int cnt = countForNum.get(num);
        if (cnt > 1) {
            return cnt;
        }
        cnt = forward(countForNum, num + 1) + 1;
        countForNum.put(num, cnt);
        return cnt;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 3, 2, 2, 2, 5, 2, 3, 7};
        int[] nums = {100, 4, 200, 1, 3, 2};
        Num04 num04 = new Num04();
        int longestConsecutive = num04.longestConsecutive(nums);
        System.out.println(longestConsecutive);
    }
}

