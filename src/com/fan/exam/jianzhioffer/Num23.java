package com.fan.exam.jianzhioffer;

/**
 * @Description : 链表中环的入口节点
 * @Author : shulin.fan
 * @Date : 2020/7/15
 */
public class Num23 {
    public static Node meetingNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node fast = head;
        Node slow = head;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
