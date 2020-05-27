package interviewgold.cha08;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 堆箱子
 * @date : 2020/04/09.
 */

public class Thirteen {
    public int pileBox(int[][] box) {
        int len = box.length;
        Arrays.sort(box, (a, b) -> a[0] == b[0] ? a[1] == b[1] ? b[2] - a[2] : b[1] - a[1] : a[0] - b[1]);
        int[] dp = new int[len];
        dp[0] = box[0][2];
        int res = dp[0];
        for (int i = 1; i < len; ++i) {
            int max_val = 0, base_depth = box[i][1], base_height = box[i][2];
            for (int j = 0; j < i; ++j) {
                if (base_depth > box[j][1] && base_height > box[j][2]) {
                    max_val = Math.max(max_val, dp[j]);
                }
            }
            dp[i] = max_val + base_height;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

