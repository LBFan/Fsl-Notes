package com.fan.xiecehng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description : 0.67
 * @Author : shulin.fan
 * @Date : 2020/9/8
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        String sentence = sc.nextLine();
        String word = sc.nextLine();

        System.out.println(replaceWord(target, sentence, word));

    }

    private static String replaceWord(String target, String sentence, String word) {
        int start = 0, end = 0;
        int temp = 0;
        StringBuilder sb = new StringBuilder();
        while (end <= sentence.length()) {
            char c = end == sentence.length() ? ' ' : sentence.charAt(end);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                temp = end;
                String s = sentence.substring(start, temp);
                if (check(s, target)) {
                    sb.replace(start, temp, word);
                    start = end + 1 + (word.length() - target.length());
                    end++;
                    continue;
                }
                start = end + 1;
            }
            end++;
        }
        return sb.toString();
    }

    private static boolean check(String s1, String s2) {
        if (s1 == null) {
            return false;
        }
        char[] arr1 = s1.toCharArray();
        Arrays.sort(arr1);
        String str1 = String.valueOf(arr1);
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr2);
        String str2 = String.valueOf(arr2);
        return str1.equals(str2);
    }
}
