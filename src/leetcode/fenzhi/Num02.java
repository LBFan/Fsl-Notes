package leetcode.fenzhi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description : 不同的二叉搜索树
 * 给定一个数字 n，要求生成所有值为 1...n 的二叉搜索树。
 * <p>
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * @date : 2020/02/14.
 */

public class Num02 {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new LinkedList<TreeNode>();
        }
        return generateSubtrees(1, n);
    }

    private List<TreeNode> generateSubtrees(int s, int e) {
        List<TreeNode> res = new LinkedList<>();
        if (s > e) {
            res.add(null);
            return res;
        }
        for (int i = s; i <= e; i++) {
            // 分治思想，分别求出左右子树，然后组合
            List<TreeNode> leftTree = generateSubtrees(s, i - 1);
            List<TreeNode> rightTree = generateSubtrees(i + 1, e);
            for (TreeNode l : leftTree) {
                for (TreeNode r : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        List<TreeNode> treeNodes = new Num02().generateTrees(n);
        for (TreeNode e :
                treeNodes) {
            System.out.println(e);
        }
    }
}

