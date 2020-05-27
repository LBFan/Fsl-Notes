package leetcode.search.dfs.backtracking;

/**
 * @author :  PF_23
 * @Description : 在矩阵中寻找字符串
 * For example,
 * Given board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * @date : 2020/02/23.
 */

public class Num03 {
    private final static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//    private int m;
//    private int n;

//    public boolean exist(char[][] board, String word) {
//        if (word == null || word.length() == 0) {
//            return true;
//        }
//        if (board == null || board.length == 0 || board[0].length == 0) {
//            return false;
//        }
//        m = board.length;
//        n = board[0].length;
//        boolean[][] hasVisited = new boolean[m][n];
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (backTracking(0, i, j, hasVisited, board, word)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    private boolean backTracking(int curLen, int r, int c, boolean[][] hasVisited, char[][] board,
                                 String word) {
        if (curLen == word.length()) {
            return true;
        }
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length
                || board[r][c] != word.charAt(curLen) || hasVisited[r][c]) {
            return false;
        }
        hasVisited[r][c] = true;

        for (int[] d : direction) {
            if (backTracking(curLen + 1, r + d[0], c + d[1], hasVisited, board, word)) {
                return true;
            }
        }
        hasVisited[r][c] = false;
        return false;
    }

    /**
     * 将一维数组转换为二维数组（矩阵）
     *
     * @param s
     * @param rows
     * @param cols
     * @return
     */
    private char[][] switcharr(char[] s, int rows, int cols) {
        char[][] board = new char[rows][cols];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = s[k++];
            }
        }
        return board;
    }

    boolean hasPath(char[] board, int rows, int cols, char[] str) {
        if (str == null || str.length == 0) {
            return true;
        }
        if (board == null || board.length == 0) {
            return false;
        }
        char[][] matrix = switcharr(board, rows, cols);
        boolean[][] hasVisited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backTracking(0, i, j, hasVisited, matrix, str.toString())) {
                    return true;
                }
            }
        }
        return false;
    }
}

