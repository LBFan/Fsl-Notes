package com.fan.leetcode.everydaycoding;

import com.fan.util.ListNode;

/**
 * @author : PF_23
 * @Description : 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * @date : 2020/04/26.
 */

public class TwentyThree {
    /**
     * 两两合并法 ：分治思想
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int left = 0, right = lists.length - 1;
        while (right > 0) {
            while (left < right) {
                lists[left] = merge(lists[left], lists[right]);
                left++;
                right--;
            }
            left = 0;
        }
        return lists[0];
    }

    /**
     * 合并两个有序链表
     *
     * @param node1 链表1
     * @param node2 链表2
     * @return 合并后的有序链表的第一个结点
     */
    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        while (node1 != null || node2 != null) {
            if (node1.val < node2.val) {
                pre.next = node1;
                node1 = node1.next;
                pre = pre.next;
            } else {
                pre.next = node2;
                node2 = node2.next;
                pre = pre.next;
            }
        }
        // 此时总有一个为空
        pre.next = node1 == null ? node2 : node1;
        return head.next;
    }

}

