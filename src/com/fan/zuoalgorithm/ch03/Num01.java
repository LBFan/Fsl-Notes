package com.fan.zuoalgorithm.ch03;

import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 分别用递归和非递归的方式实现二叉树的前序、中序和后序遍历
 * @date : 2020/01/02.
 */

public class Num01 {

    //*******************************
    // recur
    //*******************************

    public void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        while (head != null) {
            System.out.println(head.value + "    ");
            preOrderRecur(head.left);
            preOrderRecur(head.right);
        }
    }

    public void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        while (head != null) {
            inOrderRecur(head.left);
            System.out.println(head.value + "    ");
            inOrderRecur(head.right);
        }
    }

    public void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        while (head != null) {
            posOrderRecur(head.left);
            posOrderRecur(head.right);
            System.out.println(head.value);
        }
    }

    //*******************************
    // unRecur
    //*******************************

    public void preOrderUnRecur(Node head) {
        System.out.println("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value + "    ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public void inOrderUnRecur(Node head) {
        System.out.println("in-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.value + "    ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    public void posOrderUnRecur1(Node head) {
        System.out.println("pos-order: ");
        if (head != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().value + "    ");
            }
        }
        System.out.println();
    }

    public void posOrderUnRecur2(Node head) {
        System.out.println("pos-order:");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && head != c.left && head != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && head != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.println(stack.pop().value + "    ");
                    head = c;
                }
            }
        }
        System.out.println();
    }

}

