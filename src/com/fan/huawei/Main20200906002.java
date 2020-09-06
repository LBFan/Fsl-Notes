package com.fan.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : PF_23
 * @Description :
 * @date : 2020/09/06.
 */

public class Main20200906002 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        List<String> list = new ArrayList<>();
//        String line;
//        while (scanner.hasNextLine()) {
//            line = scanner.nextLine();
//            list.add(line);
//            if (line.length() == 1) {
//                break;
//            }
//        }
//        list.add(scanner.nextLine());
//        List<String> steps = steps(list);
//        for (String s : steps) {
//            System.out.println(s);
//        }

        String s = "  this  is a book   ";
        String[] arr = s.trim().split(" ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].trim());
        }
    }

    private static List<String> steps(List<String> list) {
        if (list.size() < 3) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        int n = list.size();
        int threshold = Integer.parseInt(list.get(n - 2));
        // 求出所给特征值
        String s = list.get(n - 1);
        String spe = getSpe(s, threshold);
        for (int i = 0; i < n - 2; i++) {
            String s1 = list.get(i);
            String tmp = getSpe(s1, threshold);
            if ("".equals(tmp)) {
                continue;
            }
            int c = tmp.compareTo(spe);
            if (c <= 0) {
                res.add(s1);
            }
        }
        return res;
    }

    private static String getSpe(String s, int threshold) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch - '0' < threshold) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

