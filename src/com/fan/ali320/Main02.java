package com.fan.ali320;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 作者：juwir
 链接：https://www.nowcoder.com/discuss/387100
 来源：牛客网

 一堆各自非递减的字串，能组成的最长非递减字串的长度

 题目大概是这样的，小明在学旋律，每段旋律都可以用字符串来表示，并且旋律的每个
 字符的ASCALL码递增的
 比如以下4段旋律 :
 aaa
 bcd
 bcdef
 zzz
 现在就是要求，小明能够吧这些旋律拼接起来组成最长的旋律。
 比如上述例子输出 11 最长的旋律为 aaabcdefzzz

 */
import java.util.*;

/**
 * 阿里笔试第2题，最长旋律
 *
 * @author wuddong
 * @date 2020-03-20 08:48
 */
public class Main02 {
    /**
     * 动态保存全部最大值
     */
    private int maxLength = 0;
    /**
     * 后缀和，减枝的时候用到
     */
    private int[] lengthLeft;
    /**
     * 旋律，由输入满足每个字符串递增
     */
    private List<String> melodies;

    /**
     * memo solver max length
     */
    private int memoMaxLength = 0;

    public Main02(List<String> melodies) {
        melodies.sort(String::compareTo);
        this.melodies = melodies;
        lengthLeft = new int[melodies.size() + 1];
        // 进行排序, 时间复杂度O(nlog(n))
        melodies.sort(String::compareTo);
        for (int i = melodies.size() - 1; i >= 0; i--) {
            lengthLeft[i] = melodies.get(i).length() + lengthLeft[i + 1];
        }
    }

    private int memoSolver() {
        return memoSolver(new Integer[melodies.size()], 0);
    }

    /**
     * 自定向下记忆法
     * 时间复杂度O(N^2)
     */
    private int memoSolver(Integer[] memo, int start) {
        if (start == melodies.size() - 1) {
            memo[start] = melodies.get(start).length();
        }
        if (memo[start] != null) {
            return memo[start];
        }
        String curString = melodies.get(start);
        int curLen = curString.length();
        for (int i = start + 1; i < melodies.size(); i++) {
            int next = memoSolver(memo, i);
            if (curString.charAt(curString.length() - 1) <= melodies.get(i).charAt(0)) {
                memoMaxLength = Math.max(memoMaxLength, curLen + next);
            }
        }
        memo[start] = memoMaxLength;
        return memoMaxLength;
    }


    /**
     * 动态规划解决该问题，时间复杂度O(N^2)
     * 空间复杂度O(N)
     *
     * @return maxLengthOfCombineMelodyLength
     */
    private int dynamicSolver() {
        String[] mel = new String[melodies.size()];
        melodies.toArray(mel);
        int[] dp = new int[mel.length];
        for (int j = mel.length - 1; j >= 0; j--) {
            for (int i = j; i < mel.length; i++) {
                if (i == j) {
                    dp[j] = mel[j].length();
                } else if (mel[j].charAt(mel[j].length() - 1) <= mel[i].charAt(0)) {
                    dp[j] = Math.max(dp[j], mel[j].length() + dp[i]);
                }
            }
        }
        return dp[0];
    }

    /**
     * 递归回溯解决问题
     * 时间复杂度 2^N
     *
     * @return maxLengthOfCombineMelodyLength
     */
    public int solve() {
        // 减枝法
        nextMelody(melodies, 0, 0);
        dynamicSolver();
        // 动态规划
        if (dynamicSolver() != maxLength) {
            throw new RuntimeException("dynamicSolver 和 减枝法 解法不一致");
        }
        // 记忆法
        if (memoSolver() != maxLength) {
            System.out.println(memoMaxLength);
            throw new RuntimeException("memoSolver 和 减枝法 不一样");
        }
        return maxLength;

    }

    private void nextMelody(List<String> melodies, int n, int curLength) {
        if (n == melodies.size()) {
            return;
        }
        String curMelody = melodies.get(n);
        curLength += curMelody.length();
        maxLength = Math.max(maxLength, curLength);
        char curMelodyLastChar = curMelody.charAt(curMelody.length() - 1);
        for (int i = n + 1; i < melodies.size(); i++) {
            char nextMelodyFirstChar = melodies.get(i).charAt(0);
            int cmp = curMelodyLastChar - nextMelodyFirstChar;
            if (cmp <= 0 && curLength + lengthLeft[i] > maxLength) {
                nextMelody(melodies, i, curLength);
            }
        }
    }


    /**
     * 执行入口
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> melodies = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            String input = sc.nextLine();
            if (input.length() == 0) {
                continue;
            }
            melodies.add(input);
        }
        Main02 mainSolver = new Main02(melodies);
        System.out.println(mainSolver.solve());
    }

    /**
     * 临场时想到的方法 解法出错
     * 不通过
     */
    private static int maxLengthOfMelodies(List<String> melodies) {
        melodies.sort(String::compareTo);
        StringBuilder sb = new StringBuilder();
        melodies.forEach(sb::append);
        String melodiesConcat = sb.toString();
        System.out.println(melodiesConcat);
        // 最长上升子序列
        // 处理相同的
        int[] dp = new int[melodiesConcat.length()];
        int len = 0;
        int skip = 0;
        int last = -1;
        for (char c : melodiesConcat.toCharArray()) {
            int cur = c - '0';
            if (last == cur) {
                skip++;
                continue;
            }
            int i = Arrays.binarySearch(dp, 0, len, cur);
            if (i < 0) {
                // 新单词
                i = -(i + 1);
            }
            if (i == len) {
                len++;
            }
            dp[i] = cur;
            last = cur;
        }
        return len + skip;
    }
}