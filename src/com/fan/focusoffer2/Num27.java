package com.fan.focusoffer2;

/**
 * @author : PF_23
 * @Description : 回文链表
 * @date : 2022/3/17 22:17.
 */

public class Num27 {
    /**
     * 找出后半部分，反转，对比前半部分，如果是奇数个，前半部分最后一个节点不管
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 分成两部分
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 后半部分链表
        ListNode tmp = slow.next;

        // 断开前半部分后后半部分的连接
        slow.next = null;

        // 原地反转后半部分
        ListNode second = reverseList(tmp);
        // 对比
        return equalsLit(head, second);

    }

    private boolean equalsLit(ListNode head, ListNode second) {
        while (head != null && second != null) {
            if (head.val != second.val) {
                return false;
            }
        }
        return true;
    }

    private ListNode reverseList(ListNode tmp) {
        ListNode pre = null;
        ListNode cur = tmp;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}

