package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 合并两个排序的链表 和并多个排序链表使用归并思想
 * @date : 2019/12/23.
 */

public class Num25 {
    /**
     * 迭代 常规解法
     *
     * @param head1
     * @param head2
     * @return
     */
    public Node mergeNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        Node p = new Node(-1);
        Node cur = p;
        while (head1 != null || head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                head1 = head1.next;
                cur = cur.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
                cur = cur.next;
            }
        }

        while (head1 != null) {
            cur.next = head1;
        }

        while (head2 != null) {
            cur.next = head2;
        }
        return p.next;
    }

    /**
     * 递归
     *
     * @param head1
     * @param head2
     * @return
     */
    public Node Merge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.val <= head2.val) {
            head1.next = Merge(head1.next, head2);
            return head1;
        } else {
            head2.next = Merge(head1, head2.next);
            return head2;
        }
    }
}

