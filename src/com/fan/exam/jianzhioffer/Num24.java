package com.fan.exam.jianzhioffer;

/**
 * @Description : 反转链表 与逆序打印链表其实是一个题
 * @Author : shulin.fan
 * @Date : 2020/7/15
 */
public class Num24 {
    /**
     * 头插法
     *
     * @param head 头结点
     * @return 逆序头结点
     */
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head, newHead = new ListNode(-1);
        while (cur != null) {
            ListNode next = cur.next;
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
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reverseList = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reverseList;
    }

    // 方法3 ： 栈
}
