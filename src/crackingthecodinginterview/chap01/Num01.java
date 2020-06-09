package crackingthecodinginterview.chap01;

/**
 * @author : PF_23
 * @Description : is unique
 * @date : 2020/06/09.
 */

public class Num01 {
    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                // already found
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
}

