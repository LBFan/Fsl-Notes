package interviewgold.cha01;

/**
 * @author :  PF_23
 * @Description : 一次编辑
 * 主要思路是，只有一个地方需要修改，那么不妨定位到不同字符处。有以下两种情况
 * （1）leetcode 与 leetkode。
 * 那么我们需要找到 'c' 和 'k'，然后比较 'ode' 和 'ode' 是否相同。
 * （2）leetcode 与 leetode。
 * 我们发现 'c' 和 'o' 不相同，然后比较 'ode' 和 'ode' 是否相同。
 * @date : 2020/04/08.
 */

public class Five {
    public boolean oneEditAway(String first, String second) {
        if (first == null || second == null) {
            return false;
        }
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }
        // 这里主要是将长的字符串放在first:保持第一个比第二个长
        if (len2 > len1) {
            return oneEditAway(second, first);
        }

        for (int i = 0; i < len2; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                // 如果是长度相同字符串，那就比较下一个，如果长度不一样，那就从该字符开始进行比较。
                return first.substring(i + 1).equals(second.substring(len1 == len2 ? i + 1 : i));
            }
        }
        return true;
    }
}

