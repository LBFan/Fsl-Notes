package com.fan.focusoffer2.weekexam.week3;

/**
 * @author : PF_23
 * @Description : 删除倒数第n个节点
 * @date : 2022/3/19 09:50.
 */

public class Num21 {
    /**
     * 思路： 因为是单链表：所以要删除倒数第k个节点，就要找到倒数第 K + 1个节点，然后将其next指针指向next.next
     * 使用双指针：第一个指针首先向前走k步，第二个指针不懂；
     * 然后第一个指针继续往前走，第二个指针也就一起往前，保证第第一个指针与第二个指针的距离始终是 k , 那么第二个指针走到最后一个节点时，第二个指针就是在倒数第 k + 1个节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode deleteKth(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        for (int i = 0; i < k; i++) {
            first = first.next;
        }

        // 哨兵节点：对于需要增删头结点的需要首先想到使用哨兵节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode second = dummy;
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // 此时的second就是倒数第 k + 1个节点
        second.next = second.next.next;
        return dummy.next;
    }
}

