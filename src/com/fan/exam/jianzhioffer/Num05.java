package com.fan.exam.jianzhioffer;

/**
 * @Description : 替换字符串空格
 * @Author : shulin.fan
 * @Date : 2020/7/13
 */
public class Num05 {
    //public static String replaceSpaces(StringBuffer stringBuffer) {
    //    if (stringBuffer == null || stringBuffer.length() <= 0) {
    //        return null;
    //    }
    //    int p1 = stringBuffer.length();
    //    for (int i = 0; i < p1; i++) {
    //        if (stringBuffer.charAt(i) == ' ') {
    //            stringBuffer.append("  ");
    //        }
    //    }
    //    int p2 = stringBuffer.length();
    //    // 注意边界
    //    while (p1 > 0 && p2 >= p1) {
    //        char c = stringBuffer.charAt(--p1);
    //        if (c == ' ') {
    //            stringBuffer.setCharAt(--p2, '0');
    //            stringBuffer.setCharAt(--p2, '2');
    //            stringBuffer.setCharAt(--p2, '%');
    //        } else {
    //            stringBuffer.setCharAt(--p2, c);
    //        }
    //    }
    //    return stringBuffer.toString();
    //}

    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        return new String(array, 0, size);
    }


    public static void main(String[] args) {
        //StringBuffer stringBuffer = new StringBuffer("sdfg rtyv gtgh 4 ");
        //String s = replaceSpaces(stringBuffer);
        //System.out.println(s);
    }
}
