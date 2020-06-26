package com.fan.zuoalgorithm.ch02;

import java.util.HashMap;

/**
 * @author :  PF_23
 * @Description : 复制含有随机指针节点的链表
 * @date : 2019/11/21.
 */

public class Num09 {
    /**
     * 普通解法：利用hash表
     *
     * @param head
     * @return
     */
    public RanNode copyListWithRand1(RanNode head) {
        HashMap<RanNode, RanNode> map = new HashMap<>();
        RanNode cur = head;
        while (cur != null) {
            map.put(cur, new RanNode(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 进阶解法：先将每一个节点复制放在节点后面，然后设置每一个节点的随机节点，最后拆分链表，返回复制链表
     *
     * @param head 头结点
     * @return 复制链表的头结点
     */
    public static RanNode copyListWithRand2(RanNode head) {
        if (head == null) {
            return null;
        }
        RanNode cur = head;
        RanNode next = null;
        // 复制并链接每一个节点
        while (cur != null) {
            next = cur.next;
            cur.next = new RanNode(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        RanNode curCopy = null;
        // 设置复制节点的rand指针
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        RanNode res = head.next;
        cur = head;
        // 拆分
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }


}

