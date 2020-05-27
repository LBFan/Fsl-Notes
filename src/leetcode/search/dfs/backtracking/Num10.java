package leetcode.search.dfs.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description : 1-9 数字的组合求和
 * Input: k = 3, n = 9
 *
 * Output:
 *
 * [[1,2,6], [1,3,5], [2,3,4]]
 * 从 1-9 数字中选出 k 个数不重复的数，使得它们的和为 n。
 * @date : 2020/02/23.
 */

public class Num10 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        backtracking(combinations, paths, 0, k, n);
        return combinations;
    }

    private void backtracking(List<List<Integer>> combinations, List<Integer> tempCombinations, int start, int k, int n) {
        if (k == 0 && n == 0) {
            combinations.add(new ArrayList<>(tempCombinations));
            return;
        }
        if (k == 0 || n == 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            tempCombinations.add(i);
            backtracking(combinations, tempCombinations, i + 1, k - 1, n - i);
            tempCombinations.remove(tempCombinations.size() - 1);
        }
    }
}

