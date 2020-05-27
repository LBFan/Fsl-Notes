package focusonoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :  PF_23
 * @Description : 字符流中第一个不重复的字符
 * <p>
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
 * 当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
 *
 * 思路： 双端队列解决
 * @date : 2019/12/27.
 */

public class Num41PlusTwo {

    private char[] cnts = new char[256];

    private Queue<Character> queue = new LinkedList<>();

    private void insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1) {
            queue.poll();
        }
    }
    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}

