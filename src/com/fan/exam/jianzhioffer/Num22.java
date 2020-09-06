package com.fan.exam.jianzhioffer;

/**
 * @Description : 链表中倒数第K个节点
 * @Author : shulin.fan
 * @Date : 2020/7/15
 */
public class Num22 {
    public static ListNode lastKth(ListNode head, int k) {
        //if (head == null) {
        //    return null;
        //}
        //Node cur = head;
        //while (cur != null && k > 0) {
        //    cur = cur.next;
        //    k--;
        //}
        //
        //// k值＞链表的长度
        //if (k > 0) {
        //    return null;
        //}
        //Node p = head;
        //while (cur != null) {
        //    p = p.next;
        //    cur = cur.next;
        //}
        //return p;

        // 暂不考虑越界
        ListNode fast = head, slow = head;
        int t = 0;
        while (fast != null) {
            if (t >= k) {
                slow = slow.next;
            }
            fast = fast.next;
            t++;
        }
        return slow;
    }

}
