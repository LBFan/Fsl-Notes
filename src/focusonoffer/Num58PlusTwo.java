package focusonoffer;

/**
 * @author :  PF_23
 * @Description : 左旋转字符串
 * Input:
 * S="abcXYZdef"
 * K=3
 * Output:
 * "XYZdefabc"
 * 思路：
 * 和上一题几乎一样
 * 先将数组按照k值把两段旋转，然后旋转全部数组
 * @date : 2019/12/31.
 */

public class Num58PlusTwo {

    public String leftReverse(String str, int k) {
        if (k >= str.length()) {
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, k);
        reverse(chars, k + 1, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    public void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}

