package com.fan.focusoffer2.weekexam.week3;

/**
 * @author : PF_23
 * @Description : 链表中的数字相加
 * @date : 2022/3/19 10:38.
 */

public class Num25 {

    /**
     * 思路： 放在字符串中：变成两个字符串数字相加，与前面两个二进制字符串相加一样，只是逢10进一
     * 思路2： 反转链表。相加，结果再反转
     *
     * @param p1
     * @param p2
     * @return
     */
    public ListNode addList(ListNode p1, ListNode p2) {
        ListNode node1 = reverse(p1);
        ListNode node2 = reverse(p2);
        return reverse(addListNode(node1, node2));
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }

    private ListNode addListNode(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        // 进位
        int carry = 0;
        while (node1 != null || node2 != null) {
            int a = node1 == null ? 0 : node1.val;
            int b = node2 == null ? 0 : node2.val;

            int sum = a + b + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            tmp.next = new ListNode(sum);
            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }

            tmp = tmp.next;

        }

        if (carry == 1) {
            tmp.next = new ListNode(1);
        }
        return dummy.next;
    }
}

