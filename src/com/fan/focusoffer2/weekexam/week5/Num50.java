package com.fan.focusoffer2.weekexam.week5;

import com.fan.focusoffer2.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : PF_23
 * @Description : 向下的路劲节点之和
 * @date : 2022/4/3 11:28.
 */

public class Num50 {
    // 利用哈希表将结果存起来
    public int sum(TreeNode root, int sum) {
        // key - 当前和 ；value - 出现的次数
        Map<Integer, Integer> countSum = new HashMap<>();
        // 和为0的路劲出现了一次（初始化）
        countSum.put(0, 1);
        // pathSum代表进过的路径之和
        return dfs(root, sum, countSum, 0);

    }

    private int dfs(TreeNode root, int sum, Map<Integer, Integer> countSum, int pathSum) {
        if (root == null) {
            return 0;
        }

        pathSum += root.val;

        int count = countSum.getOrDefault(pathSum - sum, 0);

        countSum.put(pathSum, countSum.getOrDefault(pathSum, 0) + 1);

        // 前序遍历
        count += dfs(root.left, sum, countSum, pathSum);
        count += dfs(root.right, sum, countSum, pathSum);

        countSum.put(pathSum, countSum.get(pathSum) - 1);

        return count;
    }

    // 利用哈希表将结果存起来
    public int sum2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int count = startCurrentNode(root, sum);
        // 从当前节点遍历的次数之和 + 左子树节点开始遍历的次数之和 + 右子树节点开始遍历的次数之和
        return count + sum2(root.left, sum) + sum2(root.right, sum);

    }

    private int startCurrentNode(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val == sum) {
            count++;
        }
        return count + startCurrentNode(root.left, sum - root.val) + startCurrentNode(root.right, sum - root.val);
    }
}

