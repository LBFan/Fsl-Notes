package crackingthecodinginterview.chap01;

import java.util.*;

/**
 * @author : PF_23
 * @Description : Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column are set to 0.
 * @date : 2020/06/16.
 */

public class Num08 {

    /**
     * 记录存在的0所在的行和列，同时修改0 -> 1
     * 最后把记录下来的所有行和列的值都置为0
     *
     * @param matrix matrix
     */
    public static void zeroMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        Set<Integer> rowList = new HashSet<>();
        Set<Integer> colList = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowList.add(i);
                    colList.add(j);
                }
            }
        }

        // 每行置为0
        for (int i = 0; i < rowList.size(); i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }
        // 每列置为0
        for (int i = 0; i < colList.size(); i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = 0;
            }
        }
    }
}

