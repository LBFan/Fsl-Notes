package focusonoffer;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 最长不含重复字符的子字符串
 * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。
 * 例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
 * TODO
 * @date : 2019/12/30.
 */

public class Num48 {
    public int longestSubStringWithoutDuplication(String str) {
        int curLen = 0;
        int maxLen = 0;
        int[] preIndexs = new int[26];
        Arrays.fill(preIndexs, -1);
        // 遍历：如果当前字符的preIndexs为-1，表示第一次出现，
        // 比较curLen和 curI - preIndex的值，更新curLen
        for (int curI = 0; curI < str.length(); curI++) {
            int c = str.charAt(curI) - 'a';
            // 找出c上一次出现的位置
            int preI = preIndexs[c];
            if (preI == -1 || curI - preI > curLen) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = curI - preI;
            }
            preIndexs[c] = curI;
        }
        return Math.max(maxLen, curLen);
    }

    public static void main(String[] args) {
        String string = "arabcacfr";
        Num48 num48 = new Num48();
        int duplication = num48.longestSubStringWithoutDuplication(string);
        System.out.println(duplication);
    }
}

