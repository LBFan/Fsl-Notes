package focusonoffer;

import java.util.*;

/**
 * @author :  PF_23
 * @Description : 从上往下打印二叉树 二叉树层次遍历
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * <p>
 * 例如，以下二叉树层次遍历的结果为：1,2,3,4,5,6,7
 * bfs 和dfs 两种方法
 * 使用队列来进行层次遍历。
 * 不需要使用两个队列分别存储当前层的节点和下一层的节点，因为在开始遍历一层的节点时，
 * 当前队列中的节点数就是当前层的节点数，只要控制遍历这么多节点数，就能保证这次遍历的都是当前层的节点。
 * @date : 2019/12/25.
 */

public class Num32PlusOne {
    public List<Integer> PrintFromTopToBottom(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode t;
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                t = queue.poll();
                if (t == null) {
                    continue;
                }
                res.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
        }
        return res;
    }
}

