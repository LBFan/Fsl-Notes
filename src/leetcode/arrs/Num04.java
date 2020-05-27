package leetcode.arrs;

/**
 * @author :  PF_23
 * @Description : 有序矩阵查找
 * 从左到右增大，从上到下增大
 * [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ]
 * @date : 2020/02/25.
 */

public class Num04 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length - 1, n = matrix[0].length - 1;
        int row = 0, col = n;
        while (row <= m && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target > matrix[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}

