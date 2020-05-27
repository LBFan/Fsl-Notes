package leetcode.fenzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description : 给表达式加括号
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。
 * 有效的运算符号包含 +, - 以及 * 。
 * <p>
 * Input: "2-1-1".
 * <p>
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * <p>
 * Output : [0, 2]
 * @date : 2020/02/14.
 */

public class Num01 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                // 分治思想，截断左右两截，分别计算左右两边的各种结果
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        // 只有一个数字输入，直接输出
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }

    public static void main(String[] args) {
        String input = "2-1-1";
        Num01 num01 = new Num01();
        List<Integer> ways = num01.diffWaysToCompute(input);
        System.out.println(ways);
        ways.forEach(System.out::println);
    }
}

