package com.fan.hanshunping.datastructrue.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 逆波兰计算器
 * @date : 2020/03/17.
 * <p>
 * 1) 初始化两个栈:运算符栈 s1 和储存中间结果的栈 s2;
 * 2) 从左至右扫描中缀表达式;
 * 3) 遇到操作数时，将其压 s2;
 * 4) 遇到运算符时，比较其与 s1 栈顶运算符的优先级:
 * 1.如果 s1 为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈;
 * 2.否则，若优先级比栈顶运算符的高，也将运算符压入 s1;
 * 3.否则，将 s1 栈顶的运算符弹出并压入到 s2 中，再次转到(4-1)与 s1 中新的栈顶运算符相比较;
 * 5) 遇到括号时:
 * (1) 如果是左括号“(”，则直接压入 s1
 * (2) 如果是右括号“)”，则依次弹出 s1 栈顶的运算符，并压入 s2，直到遇到左括号为止，此时将这一对括号丢弃 6) 重复步骤 2 至 5，直到表达式的最右边
 * 7) 将 s1 中剩余的运算符依次弹出并压入 s2
 * 8) 依次弹出 s2 中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
 */

public class PolandNotation {

    public static void main(String[] args) {
        String expression = "321+21*62-22";
        // 中缀表达式
        List<String> infixExpressionList = toInfixExpressionList(expression);
        // 后缀（逆波兰）表达式
        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        // 计算
        int calculate = calculate(suffixExpressionList);
        System.out.println(calculate);
        System.out.println("-------------");
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +"; // 76
        List<String> listString = getListString(suffixExpression);
        int calculate1 = calculate(listString);
        System.out.println(calculate1);
    }

    /**
     * 将得到的中缀表达式对应的 List => 后缀表达式对应的 List
     *
     * @param ls
     * @return
     */
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        //定义两个栈
        Stack<String> stack = new Stack<>();
        //说明:因为 s2 这个栈，在整个转换过程中，没有 pop 操作，而且后面我们还需要逆序输出
        // 因此比较麻烦，这里我们就不用 Stack<String> 直接使用 List<String> s2
        //Stack<String> s2 = new Stack<String>();
        // 储存中间结果的栈 s2
        // 储存中间结果的 Lists2
        List<String> s2 = new ArrayList<>();
        //遍历 ls
        for (String item : ls) {
            //如果是一个数，加入 s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if ("(".equals(item)) {
                stack.push(item);
            } else if (")".equals(item)) {
                //如果是右括号“)”，则依次弹出 s1 栈顶的运算符，并压入 s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!"(".equals(stack.peek())) {
                    s2.add(stack.pop());
                }
                // !!! 将 ( 弹出 s1 栈， 消除小括号
                stack.pop();
            } else {
                //当 item 的优先级小于等于 s1 栈顶运算符, 将 s1 栈顶的运算符弹出并加入到 s2 中，
                // 再次转到(4.1) 与 s1 中新的栈顶运算符相比较
                //问题:我们缺少一个比较优先级高低的方法 ,因此定义了一个类
                while (stack.size() != 0 && Operation.getValue(stack.peek()) >= Operation.getValue(item)) {
                    s2.add(stack.pop());
                }
                //还需要将 item 压入栈
                stack.push(item);
            }
        }
        //将 stack 中剩余的运算符依次弹出并加入 s2
        while (stack.size() != 0) {
            s2.add(stack.pop());
        }
        //注意因为是存放到 List, 因此按顺序输出就是对应的后缀表达式对应的 List
        return s2;
    }

    /**
     * 中缀表达式转成对应的 List
     */
    public static List<String> toInfixExpressionList(String s) {
        //定义一个 List,存放中缀表达式 对应的内容
        List<String> ls = new ArrayList<>();
        //这是一个指针，用于遍历 中缀表达式字符串
        int i = 0;
        // 对多位数的拼接
        String str;
        // 每遍历到一个字符，就放入到 c
        char c;
        do {
            //如果 c 是一个非数字，我需要加入到 ls
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {
                //如果是一个数，需要考虑多位数
                //先将 sb 置成"" '0'[48]->'9'[57]
                StringBuffer sb = new StringBuffer();
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    // 拼接
                    sb.append(c);
                    i++;
                }
                ls.add(sb.toString());
            }
        } while (i < s.length());
        //返回
        return ls;
    }

    /**
     * 将一个逆波兰表达式，依次将数据和运算符 放入到 ArrayList 中
     *
     * @param suffixExpression 后缀表达式
     * @return 集合
     */
    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> res = new ArrayList<>();
        for (String item : split) {
            res.add(item);
        }
        return res;
    }

    /**
     * 完成对逆波兰表达式的运算
     */

    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            // 匹配多位数字
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num1 = Integer.valueOf(stack.pop());
                int num2 = Integer.valueOf(stack.pop());
                int res;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    // 注意顺序
                    res = num2 - num1;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num2 / num1;
                } else {
                    throw new RuntimeException("运算符有误!");
                }
                stack.push("" + res);
            }
        }
        //最后留在 stack 中的数据是运算结果
        return Integer.valueOf(stack.pop());
    }
}

/**
 * 编写一个类 Operation 可以返回一个运算符 对应的优先级
 */
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }

}

