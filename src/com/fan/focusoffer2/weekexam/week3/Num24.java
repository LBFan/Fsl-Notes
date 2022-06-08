package com.fan.focusoffer2.weekexam.week3;

/**
 * @author : PF_23
 * @Description : 反转链表
 * @date : 2022/3/19 10:36.
 */

public class Num24 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}

