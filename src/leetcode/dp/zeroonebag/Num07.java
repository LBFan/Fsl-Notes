package leetcode.dp.zeroonebag;

import java.util.List;

/**
 * @author :  PF_23
 * @Description : 字符串按单词列表分割
 * <p>
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 * <p>
 * dict 中的单词没有使用次数的限制，因此这是一个完全背包问题。
 * <p>
 * 该问题涉及到字典中单词的使用顺序，也就是说物品必须按一定顺序放入背包中，例如下面的 dict 就不够组成字符串 "leetcode"：
 * ["lee", "tc", "cod"]
 * 求解顺序的完全背包问题时，对物品的迭代应该放在最里层，对背包的迭代放在外层，只有这样才能让物品按一定顺序放入背包中。
 * @date : 2020/01/13.
 */

public class Num07 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++){
            // 对物品的迭代应该放在最里层
            for (String word : wordDict) {
                int len = word.length();
                if (len <= i && word.equals(s.substring(i - len, i))) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[n];
    }
}

