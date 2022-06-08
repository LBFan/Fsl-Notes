package com.fan.focusoffer2.weekexam.week8;


/**
 * @author : PF_23
 * @Description : 链表排序
 * @date : 2022/5/14 10:47.
 */

public class Num77 {
    //归并排序

    public ListNode sortList(ListNode head) {
        // 先截成两个链表，然后分别将两个链表排序，最后合并两个排序链表
        if (head == null || head.next == null) {
            return head;
        }

        ListNode head1 = head;
        ListNode head2 = split(head);

        head1 = sortList(head1);
        head2 = sortList(head2);

        return merge(head1, head2);
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        // 合并两个链表,组成一个有序链表
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }

            cur = cur.next;
        }

        // 看看是哪个链表还有剩，放在cur后面
        cur.next = head1 == null ? head2 : head1;
        return dummy.next;
    }

    private ListNode split(ListNode head) {
        //将链表分成两个链表，并且返回第二个链表头
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        // 要将一个链表分成两个链表，这一步是关键
        slow.next = null;

        return second;
    }
}

