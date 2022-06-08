package com.fan.focusoffer2.weekexam.week8;

import static com.fan.focusoffer2.weekexam.week8.Num77.merge;

/**
 * @author : PF_23
 * @Description : 合并排序链表,依然使用归并排序
 * @date : 2022/5/14 10:48.
 */

public class Num78 {

    // 上一题是将两个链表合并成一个，这个题一样的，只是变成更多个链表，使用递归的方式合并
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return mergeLists(lists, 0, lists.length);
    }

    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        //要理解思想,为啥tart + 1 == end时，返回lists[start]，因为这时只有一个链表lists[start]
        if (start + 1 == end) {
            return lists[start];
        }

        // 最终结果放在第一个链表上面
        int mid = (start + end) / 2;
        ListNode head1 = mergeLists(lists, start, mid);
        ListNode head2 = mergeLists(lists, mid, end);

        return merge(head1, head2);

    }
}

