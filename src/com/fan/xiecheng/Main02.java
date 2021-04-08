package com.fan.xiecheng;

import java.util.*;

/**
 * @Description : 0.67
 * @Author : shulin.fan
 * @Date : 2020/9/8
 */
public class Main02 {
    static List<String> ans = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String[] strArr = s.split(" ");
        List<String> list = Arrays.asList(strArr);
        List<String> strings = help(list);
        for (String ss : strings) {
            System.out.println(ss);
        }
    }

    private static List<String> help(List<String> list) {
        dfs(list, 0);
        ans.sort((s1, s2) -> {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    return s1.charAt(i) - s2.charAt(i);
                }
            }
            return 0;
        });
        return ans;
    }

    private static void dfs(List<String> list, int i) {
        if (i == list.size()) {
            ans.add(sb.toString());
            return;
        }
        String str= list.get(i);
        for (char ch : str.toCharArray()) {
            sb.append(ch);
            dfs(list, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
