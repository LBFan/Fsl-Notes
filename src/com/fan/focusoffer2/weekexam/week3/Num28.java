package com.fan.focusoffer2.weekexam.week3;


import org.w3c.dom.Node;

/**
 * @author : PF_23
 * @Description : 战平多级双向链表
 * @date : 2022/3/19 11:10.
 */

public class Num28 {

    public Node flatten(Node head) {
        flat(head);
        return head;
    }

    private Node flat(Node head) {
        Node node = head;
        Node tail = null;
        while (node != null) {
            Node next = node.next;
            if (node.child != null) {
                Node child = node.child;
                Node childTail = flat(child);

                // 展评过程
                node.child = null;
                node.next = child;
                child.pre = node;

                childTail.next = next;
                if (next != null) {
                    next.pre = childTail;
                }
                tail = childTail;
            } else {
                tail = node;
            }

            node = next;
        }

        return tail;

    }

    public static class Node {
        int val;
        Node next;
        Node pre;
        Node child;

        public Node(int val) {
            this.val = val;
        }
    }
}

