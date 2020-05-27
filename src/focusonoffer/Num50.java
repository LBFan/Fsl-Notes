package focusonoffer;

import java.util.BitSet;

/**
 * @author :  PF_23
 * @Description : 第一个只出现一次的字符位置
 * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。
 * Input: abacc
 * Output: 1
 * <p>
 * 最直观的解法是使用 HashMap 对出现次数进行统计，但是考虑到要统计的字符范围有限，
 * 因此可以使用整型数组代替 HashMap，从而将空间复杂度由 O(N) 降低为 O(1)。
 * @date : 2019/12/30.
 */

public class Num50 {
    public int FirstNotRepeatingChar(String str) {
        int[] cnt = new int[256];
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (cnt[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 更优解
     * 考虑到只需要找到只出现一次的字符，那么需要统计的次数信息只有 0,1,更大，使用两个比特位就能存储这些信息。
     *
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar2(String str) {
        BitSet b1 = new BitSet();
        BitSet b2 = new BitSet();
        for (char c : str.toCharArray()) {
            if (!b1.get(c) && !b2.get(c)) {
                b1.set(c);
            } else if (b1.get(c) && !b2.get(c)) {
                b2.set(c);
            }
            // 出现多次的，即在两个bit中都出现过，直接忽略（因为肯定是重复字符）
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (b1.get(c) && !b2.get(c)) {
                return i;
            }
        }
        return -1;

    }
}

