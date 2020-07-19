package com.fan.exam.jianzhioffer;

/**
 * @Description : 树的两个节点的最低公共祖先 （平衡二叉树）
 * @Author : shulin.fan
 * @Date : 2020/7/19
 */
public class Num68 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
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
