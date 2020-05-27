package focusonoffer;

/**
 * @author :  PF_23
 * @Description : 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * <p>
 * 中序遍历
 * @date : 2019/12/25.
 */

public class Num36 {
    public TreeNode pre;
    public TreeNode head;

    public TreeNode treeToDoublyList(TreeNode root) {
        inOrder(root);
        return root;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        root.left = pre;
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        if (head == null) {
            head = root;
        }
        inOrder(root.right);
    }
}

