package com.fan.focusoffer2.weekexam.week3;

/**
 * @author : PF_23
 * @Description :  两个链表的第一个重合节点
 * @date : 2022/3/19 10:21.
 */

public class Num23 {

    /**
     * 思路1： 将链表1的尾节点指向链表2的头结点，形成环，该题就变成了找环的入口节点，同上一题（此处不做了）
     * 思路2： 先求出两个链表的长度，然后得出长度差，利用两个指针求出第一个相同节点
     *
     * @param p1
     * @param p2
     * @return
     */
    public ListNode firstCommonNode(ListNode p1, ListNode p2) {
        int len1 = getLen(p1);
        int len2 = getLen(p2);
        int sub = Math.abs(len1 - len2);
        ListNode longer = len1 > len2 ? p1 : p2;
        ListNode shorter = len1 > len2 ? p2 : p1;

        for (int i = 0; i < sub; i++) {
            longer = longer.next;
        }

        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }
        return shorter;

    }

    private int getLen(ListNode p1) {
        int count = 0;
        while (p1 != null) {
            count++;
            p1 = p1.next;
        }

        return count;
    }
}

