package com.fan.focusoffer2;

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2022/4/10 23:44.
 */

public class Num99 {
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        // 使用中序遍历
// 中序遍历，使用一个变量存上一个节点的值，
        inorder(root);
    }

    private void inorder(TreeNode root){
        if( root == null) {
            return;
        }
        inorder( root. left);
        if( prev != null && prev.val > root. val){
            swap( prev, root);
            return;
        }
        prev = root;
        inorder(root.right);
    }

    private void swap(TreeNode prev, TreeNode cur){
        int tmp = prev. val;
        prev. val = cur. val;
        cur. val = tmp;
    }
}