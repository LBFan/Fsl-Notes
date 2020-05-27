package focusonoffer;

/**
 * @author :  PF_23
 * @Description : 二叉树的镜像
 * @date : 2019/12/24.
 */

public class Num27 {

    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        swap(root);
        mirror(root.left);
        mirror(root.right);
    }

    private void swap(TreeNode root) {
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
    }
}

