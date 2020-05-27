package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author :  PF_23
 * @Description : 字符串匹配
 * 0.5
 * @date : 2020/04/15.
 */

public class Main02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        if (string.length() > 1024) {
            System.out.println("FAIL");
            return;
        }
        String[] arrStr = string.split(" ");
        String keys = arrStr[0];
        String s = arrStr[1];
        String[] arr = s.split("],");
        // 最后一个串没有","

        for (String ss : arr) {
            String[] match = match(keys, s);
            for (String val : match) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static String[] match(String keys, String s) {
        int index = s.indexOf("[");
        String suffix = s.substring(0, index);
        if (!keys.equals(suffix)) {
            // 前缀不匹配，直接返回FAIL
            return new String[]{"FAIL"};
        }
        List<String> result = new ArrayList<>();
        // 对得到的十六进制进行校验，先转换成整数，如果满足，则添加
        int index01 = s.indexOf(",");
        String addr = s.substring(index + 6, index01);
        if (!addr.substring(0, 2).equalsIgnoreCase("0x")) {
            return new String[]{"FAIL"};
        }
        if (addr.length() < 3 || addr.length() > 4) {
            return new String[]{"FAIL"};
        }
        String substring = addr.substring(2);
        // 判断是否为十六进制
        if (!isHexNumber(substring)) {
            return new String[]{"FAIL"};
        }
        result.add(addr);

        int index02 = s.lastIndexOf(",");
        String mask = s.substring(index01 + 6, index02);
        if (!mask.substring(0, 2).equalsIgnoreCase("0x")) {
            return new String[]{"FAIL"};
        }
        if (mask.length() < 3 || addr.length() > 4) {
            return new String[]{"FAIL"};
        }
        String substring01 = mask.substring(2);
        // 判断是否为十六进制
        if (!"ff".equalsIgnoreCase(substring01)) {
            return new String[]{"FAIL"};
        }
        result.add(mask);
        String val;
        if (s.endsWith("]")) {
            val = s.substring(index02 + 5, s.length() - 1);
        } else {
            val = s.substring(index02 + 5);
        }
        if (!val.substring(0, 2).equalsIgnoreCase("0x")) {
            return new String[]{"FAIL"};
        }
        if (val.length() < 3 || addr.length() > 4) {
            return new String[]{"FAIL"};
        }
        String substring02 = mask.substring(2);
        // 判断是否为十六进制
        if (!isHexNumber(substring02)) {
            return new String[]{"FAIL"};
        }

        result.add(val);
        int size = result.size();
        String[] res = new String[size];
        for (int i = 0; i < size; i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    public static boolean isHexNumber(String str) {
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            char cc = str.charAt(i);
            if (cc == '0' || cc == '1' || cc == '2' || cc == '3' || cc == '4' || cc == '5' || cc == '6' || cc == '7' || cc == '8' || cc == '9' || cc == 'A' || cc == 'a' || cc == 'b' || cc == 'b' || cc == 'C' || cc == 'c' || cc == 'd' || cc == 'D' || cc == 'e' || cc == 'E' || cc == 'f' || cc == 'F') {
                flag = true;
            }
        }
        return flag;
    }
}

