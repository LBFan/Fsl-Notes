package focusonoffer;

import java.util.*;

/**
 * @author :  PF_23
 * @Description : 按之字形顺序打印二叉树
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 与上一题思路一样，只是在加入结果的时候有一个判断标识，表示是否需要反转加入。
 * @date : 2019/12/25.
 */

public class Num32PlusThree {
    public List<List<Integer>> Print(TreeNode pRoot) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean reverse = false;
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
            if (reverse) {
                Collections.reverse(tmp);
            }
            reverse = !reverse;
            if (tmp.size() != 0) {
                res.add(tmp);
            }
        }
        return res;
    }
}

