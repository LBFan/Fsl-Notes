package crackingthecodinginterview.chap01;

/**
 * @author : PF_23
 * @Description :
 * @date : 2020/06/16.
 */

public class Num09 {

    /**
     * 如果s2是s1的旋转，那么两段s1肯定包含s2
     *
     * @param s1 s1
     * @param s2 s2
     * @return isRotate ?true : false
     */
    public static boolean isRotate(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        String s = s1 + s1;
        return s.contains(s2);
    }
}

