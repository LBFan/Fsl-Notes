package leetcode.math;

/**
 * @author :  PF_23
 * @Description : 二进制加法
 * a = "11"
 * b = "1"
 * Return "100".
 * @date : 2020/02/25.
 */

public class Num06 {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuffer st = new StringBuffer();
        while (carry == 1 || i >= 0 || j >= 0) {
            if (i >= 0 && a.charAt(i--) == '1') {
                carry++;
            }
            if (j >= 0 && b.charAt(j--) == '1') {
                carry++;
            }
            st.append(carry % 2);
            carry /= 2;
        }
        return st.reverse().toString();
    }
}

