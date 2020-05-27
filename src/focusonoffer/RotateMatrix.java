package focusonoffer;

/**
 * @author :  PF_23
 * @Description : 矩阵转置
 * @date : 2019/12/25.
 */

public class RotateMatrix {
    public static void rotate(int[][] nums) {
        if (nums == null) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                swap(nums, i, j);
            }
        }
    }

    private static void swap(int[][] nums, int i, int j) {
        int tmp = nums[i][j];
        nums[i][j] = nums[j][i];
        nums[j][i] = tmp;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(nums);
        for (int[] num : nums) {
            for (int el : num) {
                System.out.print(el + "\t");
            }
            System.out.println();
        }
    }
}

