package com.fan.zuoalgorithm.ch02;

/**
 * @author :  PF_23
 * @Description : 约瑟夫环
 * @date : 2019/11/18.
 */

public class Num06 {

    public static Node josephusKill(Node head, int m) {
        if (head == null || head.next == head || m < 1) {
            return head;
        }
        int count = 0;
        Node last = head;
        while (last.next != head) {
            last = last.next;
        }
        while (last != head) {
            if (++count == m) {
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }
}

