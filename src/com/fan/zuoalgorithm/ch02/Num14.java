package com.fan.zuoalgorithm.ch02;

import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 在单链表中删除指定值得节点
 * @date : 2019/12/02.
 */

public class Num14 {

    /**
     * method one : O(N) O(N)
     * 利用桟
     * @param head
     * @param num
     * @return
     */
    public Node removeValue1(Node head, int num) {
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            if (head.value != num) {
                stack.push(head);
            }
            head = head.next;
        }
        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }

        return head;
    }

    /**
     * method two : O(N) O(1)
     *
     * @param head
     * @param num
     * @return
     */
    public Node removeValue2(Node head, int num) {
        // 找到第一个不等于num值得头结点，作为最终的头结点
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}

