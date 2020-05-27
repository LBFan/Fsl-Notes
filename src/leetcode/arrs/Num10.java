package leetcode.arrs;

/**
 * @author :  PF_23
 * @Description :对角元素相等的矩阵
 * 1234
 * 5123
 * 9512
 * <p>
 * In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]",
 * and in each diagonal all elements are the same, so the answer is True.
 * @date : 2020/02/26.
 */

public class Num10 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (!check(matrix, matrix[0][i], 0, i)) {
                return false;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (!check(matrix, matrix[i][0], i, 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean check(int[][] matrix, int expectValue, int row, int col) {
        if (row >= matrix.length || col >= matrix[0].length) {
            return true;
        }
        if (matrix[row][col] != expectValue) {
            return false;
        }
        return check(matrix, expectValue, row + 1, col + 1);
    }
}

