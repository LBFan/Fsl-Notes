package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 两个链表的第一个公共结点
 * <p>
 * 设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b + c = b + c + a + c。
 * <p>
 * 当访问链表 A 的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；
 * 同样地，当访问链表 B 的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。
 * 这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
 * @date : 2019/12/31.
 */

public class Num52 {
    public Node FindFirstCommonNode(Node pHead1, Node pHead2) {
        Node l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }
}

