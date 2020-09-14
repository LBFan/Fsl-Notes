package com.fan.ccb;

import java.util.*;

/**
 * @Description : 找出不同的单次并输出
 * 调试有问题，不管怎样都是0
 * @Author : shulin.fan
 * @Date : 2020/9/12
 */
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String words = sc.nextLine();
        String users = sc.nextLine();
        String[] word = words.split(" ");
        String[] user = users.split(" ");
        List<String> wordList = Arrays.asList(word);
        List<String> userList = Arrays.asList(user);
        List<String> list = diff(wordList, userList);
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1) {
                System.out.print("\"" + list.get(i) + "\",");
            } else {
                System.out.print("\"" + list.get(i) + "\"");
            }
        }
        System.out.print("]");

    }

    private static List<String> diff(List<String> word, List<String> user) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> wordCnt = new HashMap<>();
        Map<String, Integer> userCnt = new HashMap<>();
        for (String w : word) {
            wordCnt.put(w, wordCnt.getOrDefault(w, 0) + 1);
        }

        for (String u : user) {
            userCnt.put(u, userCnt.getOrDefault(u, 0) + 1);

        }

        // 只出现一次且另一个未出现
        for (String w : word) {
            if (wordCnt.get(w).equals(1) && !userCnt.containsKey(w)) {
                res.add(w);
            }
        }

        for (String u : user) {
            if (userCnt.get(u).equals(1) && !wordCnt.containsKey(u)) {
                res.add(u);
            }
        }

        return res;
    }
}
