package focusonoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description : 顺时针打印矩阵
 * 1，  2， 3， 4
 * 5，  6， 7， 8
 * 9， 10，11，12
 * 13，14，15，16
 * 矩阵顺时针打印结果为：1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10
 * @date : 2019/12/25.
 */

public class Num29 {
    public static List<Integer> printMatrix(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        int rows = matrix.length, cols = matrix[0].length;
        int r1 = 0, r2 = rows - 1, c1 = 0, c2 = cols - 1;
        while (r1 <= r2 && c1 <= c2) {
            // 左 -> 右
            for (int i = c1; i <= c2; i++) {
                ret.add(matrix[r1][i]);
            }
            // 上 —> 下
            for (int i = r1 + 1; i <= r2; i++) {
                ret.add(matrix[i][c2]);
            }
            if (r1 != r2) {
                // 右 -> 左
                for (int i = c2 - 1; i >= c1; i--) {
                    ret.add(matrix[r2][i]);
                }
            }
            if (c1 != c2) {
                // 下 -> 上
                for (int i = r2 - 1; i > r1; i--) {
                    ret.add(matrix[i][c1]);
                }
            }
            r1++;
            c1++;
            r2--;
            c2--;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        List<Integer> list = printMatrix(matrix);
        System.out.println(list.toString());
    }

}

