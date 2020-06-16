package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 树中两个节点的最低公共祖先
 * 二叉查找树
 * 在二叉查找树中，两个节点 p, q 的公共祖先 root 满足 root.val >= p.val && root.val <= q.val。
 * @date : 2019/12/31.
 */

public class Num68PlusOne {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            // 均在左子树上
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            // 均在右子树上
            return lowestCommonAncestor(root.right, p, q);
        }
        // p和q分别在左子树和右子树上
        return root;
    }
}

