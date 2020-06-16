package com.fan.leetcode.everydaycoding;

import com.fan.util.ListNode;

import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 两数相加
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * @date : 2020/04/14.
 */

public class FourFiveFive {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int carry = 0;
        while (l1 != null) {
            stack1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.add(l2.val);
            l2 = l2.next;
        }
        ListNode out = null;
        while (!(stack1.isEmpty() && stack2.isEmpty())) {
            int n1 = stack1.isEmpty() ? 0 : stack1.pop();
            int n2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            if (sum > 9) {
                sum = sum - 10;
            }
            ListNode node = new ListNode(sum);
            node.next = out;
            out = node;
        }
        if (carry != 0) {
            ListNode carryNode = new ListNode(carry);
            carryNode.next = out;
            out = carryNode;
        }
        return out;

    }
}

