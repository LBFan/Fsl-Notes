package com.fan.crackingthecodinginterview.chap01;

/**
 * @Description : String Compression: Implement a method to perform basic string compression using the counts of
 * repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed"
 * string would not become smaller than the original string, your method should return the original string.
 * You can assume the string has only uppercase and lowercase letters (a - z).
 * @Author : shulin.fan
 * @Date : 2020/6/10
 */
public class Num06 {
    /**
     * 返回字符串：如果压缩后的长度大于原字符串，则返回原字符串，否则返回压缩后的字符串
     *
     * @param str ￿str
     * @return 压缩后的字符串
     */
    public static String compress(String str) {
        int finalLength = countCompression(str);
        if (finalLength >= str.length()) {
            return str;
        }
        StringBuilder compressed = new StringBuilder(finalLength);
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    /**
     * 计算并返回压缩后的字符串长度
     *
     * @param str str
     * @return 压缩后的字符串长度
     */
    private static int countCompression(String str) {
        int compressionLength = 0;
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressionLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressionLength;
    }
}
