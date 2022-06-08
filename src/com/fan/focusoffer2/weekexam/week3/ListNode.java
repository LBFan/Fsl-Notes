package com.fan.focusoffer2.weekexam.week3;

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2022/3/19 09:53.
 */

public class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur= head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

