package focusonoffer;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 把数组排成最小的
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组 {3，32，321}，则打印出这三个数字能排成的最小数字为 321323。
 * <p>
 * 可以看成是一个排序问题，
 * 在比较两个字符串 S1 和 S2 的大小时，应该比较的是 S1+S2 和 S2+S1 的大小，
 * 如果 S1+S2 < S2+S1，那么应该把 S1 排在前面，否则应该把 S2 排在前面。
 * @date : 2019/12/30.
 */

public class Num45 {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; ++i) {
            str[i] = "" + numbers[i];
        }
        Arrays.sort(str, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        for (String s : str) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 32, 321};
        String minNumber = new Num45().PrintMinNumber(nums);
        System.out.println(minNumber);
    }
}

