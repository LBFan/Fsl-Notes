package focusonoffer;

/**
 * @author :  PF_23
 * @Description : 二叉树的深度
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @date : 2019/12/31.
 */

public class Num55PlusOne {
    public int TreeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}

