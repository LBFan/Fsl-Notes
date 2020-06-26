package com.fan.zuoalgorithm.ch02;

import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 两个单链表生成相加链表
 * @date : 2019/11/21.
 */

public class Num10 {
    /**
     * 方法一： 常规
     *
     * @param head1 头1
     * @param head2 头2
     * @return 结果头节点
     */
    public static Node addList1(Node head1, Node head2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (head1 != null) {
            stack1.push(head1.value);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2.value);
            head2 = head2.next;
        }
        // 进位
        int ca = 0;
        int n1, n2, n;
        Node node = null;
        Node pre;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            n1 = stack1.isEmpty() ? 0 : stack1.pop();
            n2 = stack2.isEmpty() ? 0 : stack2.pop();
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n % 10);
            node.next = pre;
            ca = n / 10;
        }
        if (ca == 1) {
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node;
    }

    /**
     * 方法二： 反转链表，然后相加，然后求出结果链表，恢复链表，返回结果链表头
     *
     * @param head1 头1
     * @param head2 头2
     * @return 结果链表头
     */
    public static Node addList2(Node head1, Node head2) {
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        int n1, n2, n;
        int ca = 0;
        Node c1 = head1;
        Node c2 = head2;
        Node node = null;
        Node pre;
        while (c1 != null || c2 != null) {
            n1 = c1 != null ? c1.value : 0;
            n2 = c2 != null ? c2.value : 0;
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n % 10);
            node.next = pre;
            ca = n / 10;
            c1 = c1 == null ? null : c1.next;
            c2 = c2 == null ? null : c2.next;
        }
        if (ca == 1) {
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        reverseList(head1);
        reverseList(head2);
        return node;
    }

    private static Node reverseList(Node head) {
        Node pre = null;
        Node next;
        while (head != null) {
            next = head.next;
            // 反转
            head.next = pre;
            pre = head;
            // 右移
            head = next;

        }
        return pre;
    }
}

