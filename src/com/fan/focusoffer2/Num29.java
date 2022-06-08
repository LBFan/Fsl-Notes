package com.fan.focusoffer2;

/**
 * @author : PF_23
 * @Description : 排序的循环链表
 * @date : 2022/3/17 22:32.
 */

public class Num29 {

    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            head = node;
            node.next = node;
        } else if (head.next == head) {
            head.next = node;
            node.next = head;
        } else {
            insetCore(head, node);
        }
        return head;
    }

    private void insetCore(Node head, Node node) {
        Node cur = head;
        Node biggest = head;
        Node next = head.next;
        while (!(cur.val <= node.val && next.val >= node.val) && next != head) {
            cur = next;
            next = next.next;
            if (cur.val >= biggest.val) {
                biggest = cur;
            }
        }

        if (cur.val <= node.val && next.val >= node.val) {
            cur.next = node;
            node.next = next;
        } else {
            node.next = biggest.next;
            biggest.next = node;
        }
    }
}

