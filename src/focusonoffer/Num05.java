package focusonoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :  PF_23
 * @Description : 替换空格
 * 将一个字符串中的空格替换成 "%20"。
 * @date : 2019/12/12.
 */

public class Num05 {
    public static String replaceSpace(StringBuffer str) {
        int P1 = str.length() - 1;
        for (int i = 0; i <= P1; i++) {
            if (str.charAt(i) == ' ') {
                // add two space at  the tail of str
                str.append("  ");
            }
        }
        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("A B");
        String s = replaceSpace(str);
        System.out.println(s);

    }
}

