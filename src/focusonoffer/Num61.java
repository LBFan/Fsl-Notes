package focusonoffer;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 扑克牌顺子
 * 五张牌，其中大小鬼为癞子，牌面为 0。判断这五张牌是否能组成顺子。
 * @date : 2019/12/31.
 */

public class Num61 {
    public boolean isContinuous(int[] nums) {
        if (nums.length < 5) {
            return false;
        }
        int cnt = 0;
        // 统计癞子数
        for (int num : nums) {
            if (num == 0) {
                cnt++;
            }
        }
        // 补全癞子
        for (int i = cnt; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                return false;
            }
            cnt -= nums[i + 1] - nums[i] + 1;
        }
        return cnt > 0;
    }
}

