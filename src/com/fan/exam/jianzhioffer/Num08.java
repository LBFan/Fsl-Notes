package com.fan.exam.jianzhioffer;

/**
 * @Description : 二叉树的下一个节点（中序遍历）
 * @Author : shulin.fan
 * @Date : 2020/7/13
 */
public class Num08 {
    /**
     * ①如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
     * ②否则，向上找第一个左链接指向的树包含该节点的祖先节点。
     */
    public TreeLinkNode GetNext(TreeLinkNode node) {
        // 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
        if (node.right != null) {
            TreeLinkNode node1 = node.next;
            while (node1.left != null) {
                node1 = node1.left;
            }
            return node1;
        } else {
            // 否则，向上找第一个左链接指向的树包含该节点的祖先节点
            while (node.next != null) {
                TreeLinkNode parent = node.next;
                if (node == parent.left) {
                    return parent;
                }
                node = parent;
            }
        }
        return null;
    }
}
