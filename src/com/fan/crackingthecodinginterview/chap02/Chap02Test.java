package com.fan.crackingthecodinginterview.chap02;

import com.fan.util.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author : PF_23
 * @Description :
 * @date : 2020/06/16.
 */

public class Chap02Test {
    @Test
    public void testNum01() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode listNode = Num01.removeDups(l1);
        l1.next = l3;
        l3.next = l4;
        l4.next = l5;
        Assert.assertNotSame(l1, listNode);
    }
}

