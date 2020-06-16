package com.fan.huawei;

import java.util.*;

/**
 * @author :  PF_23
 * @Description : 投票数最多的人
 * AC
 * @date : 2020/04/15.
 */

public class Main01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
//            // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
////        }
        String s = in.nextLine();
        String[] names = s.split(",");
//         1. 将所有的names存在map中，
//         如果最大票数只有一个人，则返回该名字
//         如果最大票数有多个人，则对人名排序，输出第一个。

//        String[] names = {"Tom", "Lily", "Tom", "Lucy", "Lucy", "Jack","Tomy","Tomy"};
//        Arrays.sort(names, (a, b) -> a.compareTo(b));
//        System.out.println(Arrays.toString(names));
        // 判断非法输入
        for (String name : names) {
            if(!getResult(name)) {
                System.out.println("error.0001");
                return;
            }
        }
        String name = starName(names);
        System.out.println(name);

    }

    private static boolean getResult(String str) {
        boolean i = false;
        if (str == null || str.length() <= 0) {
            return false;
        }
        if (str.charAt(0) >= 'A' && str.charAt(0) <= 'Z') {
            String s = str.substring(1);
            if (s.length() != 0 && s != null) {
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) >= 'a' && s.charAt(j) <= 'z') {
                        i = true;
                    } else {
                        i = false;
                        break;
                    }
                }
            } else {
                i = true;
            }
        }
        return i;
    }


    public static String starName(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        for (String name : names) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
            }
        }
        int count = 0;
        List<String> nameList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                nameList.add(entry.getKey());
                count++;
            }
        }
        if (nameList.size() == 1) {
            // 只有一个人
            return nameList.get(0);
        } else {
            String[] namesArr = nameList.toArray(new String[nameList.size()]);
            Arrays.sort(namesArr, (a, b) -> a.compareTo(b));
            return namesArr[0];
        }
    }
}

///
