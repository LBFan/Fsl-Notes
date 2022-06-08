package com.fan.focusoffer2;

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2022/3/9 23:35.
 */

public class Num14 {
    // 检查s1中是否包含s2的变位词
    // 利用哈希,

    /**
     * * 字符串中的变位词：s2中是否包含s1的某个变位词
     * * 思路：首先是暴力解，从左到右遍历s2，每遍历一次字符串长度为s1的长度，排序然后看是否equal
     * * 后面2表示s2, 1表示s1
     * * 再思考：变位词是与字符出现的次数有关系，那么可以使用一个哈希表来记录1出现的每个字符的次数，然后想办法去用到2中
     * * 因为只出现26个小写字母，所以可以使用长度为26的数组代替哈希表，下标为0的值表示字母a出现的次数，以此类推
     * * 思路如下：
     * * 1.遍历一遍1，将每个字幕出现的次数记录在数组中，出现一次就将下标对应的值加1，同时遍历2，出现一次就减1，遍历完成时变量i为1.len;
     * * 当遍历完成后，查看是否数组为所有值为0，如果为0 ，返回true，表示找到了变位词；否则执行2
     * * 2.使用双指针，从2的第2个字符开始遍历，使用双指针,第0个字母对应的数组值加1，i向右移动，数组值减去2[i]，如果数组的值都为0，表示出现了变位词，返回true；
     * * 3.否则，将left字母的数组值加1，向右移动left和i，将i字母在数组中的值减1，
     * * 4.循环2和3，直到遍历完都没有返回true，那就说明没有变位词，返回false
     */
    public boolean checkInclusion(String s1, String s2) {
        int[] countChar = new int[26];
        int i = 0;
        for (; i < s2.length(); i++) {
            countChar[s2.charAt(i) - 'a']++;
            countChar[s1.charAt(i) - 'a']--;
        }

        // 判断是否数组全为0，如果全为0，表示找到了，返回true
        if (areAllZero(countChar)) {
            return true;
        }

        for (int j = i; j < s2.length(); j++) {
            countChar[s2.charAt(j - s1.length()) - 'a']++;
            countChar[s2.charAt(j) - 'a']--;
            if (areAllZero(countChar)) {
                return true;
            }
        }

        return false;
    }

    public static boolean areAllZero(int[] countChar) {
        for (int i : countChar) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}

