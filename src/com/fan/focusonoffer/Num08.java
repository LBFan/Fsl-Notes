package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 二叉树的下一个结点
 * 请找出中序遍历顺序的下一个结点并且返回 。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * TODO: 条件二需要在纸上画出理解
 *
 * 我们先来回顾一下中序遍历的过程：先遍历树的左子树，再遍历根节点，最后再遍历右子树。所以最左节点是中序遍历的第一个节点。
 * // void traverse(TreeNode root) {
 *       if (root == null) return;
 *       traverse(root.left);
 *       visit(root);
 *       traverse(root.right);
 *   }
 * @date : 2019/12/12.
 */

public class Num08 {
    /**
     * ①如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
     * ②否则，向上找第一个左链接指向的树包含该节点的祖先节点。
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else { // 否则，向上找第一个左链接指向的树包含该节点的祖先节点
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode) {
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }
}

