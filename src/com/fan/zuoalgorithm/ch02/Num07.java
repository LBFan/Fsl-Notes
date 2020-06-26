package com.fan.zuoalgorithm.ch02;

import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 判断链表是否是回文结构
 * @date : 2019/11/19.
 */

public class Num07 {
    public static boolean isPalindrome1(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 方法二:只将链表的右半区压入桟中
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 方法三 进阶
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        // 为了求出中部遍历n2 ： 快慢指针法
        while (n2.next != null && n2.next.next != null) {
            // n1 -> 中部
            n1 = n1.next;
            // n2 -> 结尾
            n2 = n2.next.next;
        }
        // n2 -> 右部分第一个节点
        n2 = n1.next;
        // mid.next -> null
        n1.next = null;
        Node n3;
        // 反转又半区
        while (n2 != null) {
            // n3保存下一个节点
            n3 = n2.next;
            // 反转
            n2.next = n1;
            //n1右移
            n1 = n2;
            // n2右移
            n2 = n3;
        }
        // n3保存尾节点
        n3 = n1;
        // n2保存头结点
        n2 = head;
        boolean res = true;
        // 检查回文
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            // 从左到中部
            n1 = n1.next;
            // 从右到中部
            n2 = n2.next;

        }
        n1 = n3.next;
        n3.next = null;
        // 恢复链表
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(1);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        boolean palindrome3 = isPalindrome3(node);
        System.out.println(palindrome3);
    }
}

