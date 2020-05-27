package focusonoffer;

/**
 * @author :  PF_23
 * @Description : 二叉查找树的第 K 个结点
 * 思路：
 * 利用二叉查找树中序遍历有序的特点
 * @date : 2019/12/31.
 */

public class Num54 {
    private TreeNode ret;
    private int cnt = 0;

    public TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return ret;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null || cnt > k) {
            return;
        }
        inOrder(root.left, k);
        cnt++;
        if (cnt == k) {
            ret = root;
            return;
        }
        inOrder(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode  t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(7);
        TreeNode  t7 = new TreeNode(8);
        root.left = t2;
        root.right = t6;
        t2.left = t3;
        t2.right = t4;
        t6.left = t5;
        t6.right = t7;

        Num54 num54 = new Num54();
        TreeNode treeNode = num54.KthNode(root, 5);
        System.out.println(treeNode.val);

    }
}

