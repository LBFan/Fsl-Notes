package com.fan.crackingthecodinginterview.chap02;

import com.fan.util.ListNode;

/**
 * @author : PF_23
 * @Description : Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * @date : 2020/06/16.
 */

public class Num01 {
    /**
     * 使用递归删除重复的结点
     *
     * @param listNode 单链表
     */

    public static ListNode removeDups(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode next = listNode.next;
        if (listNode.val == next.val) {
            while (next != null && listNode.val == next.val) {
                next = next.next;
            }
            return removeDups(next);
        } else {
            listNode.next = removeDups(next);
            return listNode;
        }
    }
}

