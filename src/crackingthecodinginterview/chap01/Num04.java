package crackingthecodinginterview.chap01;

/**
 * @Description : 判断一个字符串是否是回文字符串的重排列
 * @Author : shulin.fan
 * @Date : 2020/6/9
 */
public class Num04 {
    public static boolean palindromePermutation1(String s) {
        if (s == null || s.length() <= 0) {
            return false;
        }
        String str = s.toLowerCase();
        // 最多只能有一个字符的个数是奇数
        int[] letters = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int x = getCharNumber(str.charAt(i));
            letters[x]++;
        }

        int count = 0;
        for (int i = 0; i < letters.length; i++) {
            count += letters[i] % 2 == 1 ? 1 : 0;
        }
        return count < 2;
    }

    private static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }
}
