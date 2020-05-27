package meiriiyti;

/**
 * @author :  PF_23
 * @Description : 旋转矩阵
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * <p>
 * 不占用额外内存空间能否做到？
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * @date : 2020/04/07.
 */

public class ZeroOneZeroSeven {

    public static void rotate(int[][] matrix) {
        // 先交换行，然后转置
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        //1. 交换行
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            swap(matrix, i, n - i - 1);
        }

        // 2. 转置
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                swapNum(matrix, i, j);
            }
        }
    }

    private static void swapNum(int[][] matrix, int i, int j) {
        int t = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = t;
    }

    private static void swap(int[][] matrix, int i, int j) {
        int tmp;
        for (int k = 0; k < matrix[0].length; k++) {
            tmp = matrix[i][k];
            matrix[i][k] = matrix[j][k];
            matrix[j][k] = tmp;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

