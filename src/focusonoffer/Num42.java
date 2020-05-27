package focusonoffer;

/**
 * @author :  PF_23
 * @Description : 连续子数组的最大和
 * {6, -3, -2, 7, -15, 1, 2, 2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）。
 * @date : 2019/12/27.
 */

public class Num42 {
    public int FindGreatestSumOfSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int generateSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum<= 0 ? nums[i] : sum + nums[i];
            generateSum = Math.max(generateSum,sum);
        }
        return generateSum;
    }

    public static void main(String[] args) {
        int[] nums = {6, -3, -2, 7, -15, 1, 2, 2};
        int greatestSumOfSubArray = new Num42().FindGreatestSumOfSubArray(nums);
        System.out.println(greatestSumOfSubArray);
    }
}

