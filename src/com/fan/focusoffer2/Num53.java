package com.fan.focusoffer2;



/**
 * @author : PF_23
 * @Description : 二叉搜索树的下一个节点
 * @date : 2022/4/9 08:51.
 */

public class Num53 {

    TreeNode result;
    public TreeNode nextNode(TreeNode root, TreeNode p) {
        // 找出节点p的下一个节点，不存在则返回null
        inorder(root, p);
        return result;
    }

    private void inorder(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        inorder(root.left, p);
        if (result == null && root.val > p.val) {
            result = root;
            return;
        }
        inorder(root.right, p);
    }
}

