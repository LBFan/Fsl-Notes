package com.fan.leetcode.binarysearch;

/**
 * @author :  PF_23
 * @Description : 大于给定元素的最小元素
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 * <p>
 * 题目描述：给定一个有序的字符数组 letters 和一个字符 target，要求找出 letters 中大于 target 的最小字符，
 * 如果找不到就返回第 1 个字符。
 * @date : 2020/02/09.
 */

public class Num02 {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (letters[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo < n ? letters[lo] : letters[0];
    }

    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char target = 'd';
        Num02 num02 = new Num02();
        char nextGreatestLetter = num02.nextGreatestLetter(letters, target);
        System.out.println(nextGreatestLetter);
    }
}

