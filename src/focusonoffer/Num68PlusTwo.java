package focusonoffer;

/**
 * @author :  PF_23
 * @Description : 树中两个节点的最低公共祖先
 * 普通二叉树
 * <p>
 * 在左右子树中查找是否存在 p 或者 q，如果 p 和 q 分别在两个子树中，那么就说明根节点就是最低公共祖先。
 * @date : 2019/12/31.
 */

public class Num68PlusTwo {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}

