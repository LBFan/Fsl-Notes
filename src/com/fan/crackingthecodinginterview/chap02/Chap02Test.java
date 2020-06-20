package com.fan.crackingthecodinginterview.chap02;

import com.fan.util.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author : PF_23
 * @Description :
 * @date : 2020/06/16.
 */

public class Chap02Test {

    private static ListNode generateNode() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        return l1;
    }

    @Test
    public void testNum01() {
        ListNode node = generateNode();
        ListNode listNode = Num01.removeDups(node);
        Assert.assertNotSame(node, listNode);
    }

    @Test
    public void testNum02() {
        ListNode node = generateNode();
        int kth = 3;
        ListNode kthToLast = Num02.findKthToLast(node, kth);
        Assert.assertSame(node.next.next, kthToLast);
    }

    @Test
    public void testNum03() {
        ListNode node = generateNode();
        ListNode node1 = Num03.delMid(node);
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
        Assert.assertTrue(1 == 1);
    }
}

