package com.fan.focusoffer2.weekexam.week3;

/**
 * @author : PF_23
 * @Description : 链表中环的入口节点
 * @date : 2022/3/19 10:08.
 */

public class Num22 {

    /**
     * 思路：
     *
     * @param head
     * @return
     */
    public ListNode cycleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next, slow = head;
        while (slow != null && fast != null) {
            if (slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        // 表示没有环
        if (fast == null) {
            return null;
        }

        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}

