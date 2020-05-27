package meiriiyti;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author :  PF_23
 * @Description : 二叉树的右视图
 * @date : 2020/04/22.
 */

public class OneNineNine {
    /**
     * 返回每一层的最右子节点的集合 BFS
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                // 将每一层最后访问的结点加入到res中
                if (i == cnt - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    /**
     * DFS
     */
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideViewDFS(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // 如果当前节点所在的深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的结点，因此将当前结点加入re中
        if (depth == res.size()) {
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }


}

