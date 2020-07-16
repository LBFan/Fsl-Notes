package com.fan.exam.jianzhioffer;

/**
 * @Description : 反转链表 与逆序打印链表其实是一个题
 * @Author : shulin.fan
 * @Date : 2020/7/15
 */
public class Num24 {
    /** 头插法
     *
     * @param head 头结点
     * @return 逆序头结点
     */
    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head, newHead = new Node(-1);
        while (cur != null) {
            Node next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        return newHead.next;
    }

    /**
     * 递归 TODO
     *
     * @param head
     * @return
     */
    public Node ReverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node next = head.next;
        head.next = null;
        Node reverseList = ReverseList(next);
        next.next = head;
        return reverseList;
    }
}
