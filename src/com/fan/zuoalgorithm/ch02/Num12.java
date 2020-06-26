package com.fan.zuoalgorithm.ch02;

import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 将单链表的每K个节点之间逆序
 * 最后不够K个节点一组就不逆序
 * @date : 2019/12/02.
 */

public class Num12 {

    /**
     * method one: stack
     *
     * @param head
     * @param k
     * @return
     */
    private static Node reverseKNodes1(Node head, int k) {
        if (k < 2) {
            return head;
        }
        Stack<Node> stack = new Stack<>();
        Node newHead = head;
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            stack.push(cur);
            if (stack.size() == k) {
                pre = resign1(stack, pre, next);
                // 确定新的链表头
                newHead = newHead == head ? cur : newHead;
            }
            cur = next;
        }
        return newHead;
    }

    private static Node resign1(Stack<Node> stack, Node left, Node right) {
        Node cur = stack.pop();
        if (left != null) {
            left.next = cur;
        }
        Node next;
        while (!stack.isEmpty()) {
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }

    /**
     * method two
     *
     * @param head
     * @param k
     * @return
     */
    private static Node reverseKNodes2(Node head, int k) {
        if (k < 2) {
            return head;
        }

        Node cur = head;
        Node start = null;
        Node pre = null;
        Node next = null;
        int count = 1;

        while (cur != null) {
            next = cur.next;
            if (count == k) {
                start = pre == null ? head : pre.next;
                head = pre == null ? cur : head;
                resign2(pre, start, cur, next);
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }

        return head;
    }

    private static void resign2(Node left, Node start, Node end, Node right) {
        Node pre = start;
        Node cur = start.next;
        Node next = null;

        while (cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 链接两段逆序后的指针1->2->3->4->5->6 ： 3->2->1->4->5->6
        if (left != null) {
            left.next = end;
        }
        // 调整头尾指针 1->2->3->4 : 3->2->1->4
        start.next = right;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next = new Node(10);

        Node node = reverseKNodes2(head, 3);
    }

}

