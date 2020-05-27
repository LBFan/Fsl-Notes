package focusonoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author :  PF_23
 * @Description : 把二叉树打印成多行
 * @date : 2019/12/25.
 */

public class Num32PlusTwo {
    public List<List<Integer>> printTreeNode(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            List<Integer> tmp = new ArrayList<>();
            while (cnt-- > 0) {
                TreeNode t = queue.poll();
                if (t == null) {
                    continue;
                }
                tmp.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            if (tmp.size() != 0) {
                res.add(tmp);
            }
        }
        return res;
    }
}

