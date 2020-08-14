package com.fan.exam.jianzhioffer;

/**
 * @Description : 矩阵中的路径
 * @Author : shulin.fan
 * @Date : 2020/7/14
 */
public class Num12 {
    boolean res = false;
    int row, col;

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return res;
        }
        char[] words = word.toCharArray();
        row = board.length;
        col = board[0].length;
        if (row * col < words.length) {
            return res;
        }
        for (int i = 0; i < row && !res; i++) {
            //遍历board，res为true时可以直接返回了。
            for (int j = 0; j < col; j++) {
                if (words[0] == board[i][j]) {
                    dfs(board, words, i, j, 0);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] board, char[] word, int i, int j, int index) {
        //找到满足的路径或路径不正确
        if (res || board[i][j] != word[index]) {
            return;
        }
        if (word.length - 1 == index) {
            //找到满足的路径
            res = true;
            return;
        }
        char temp = board[i][j];
        //标记路径
        board[i][j] = '#';
        //下
        if (i + 1 < row && board[i + 1][j] != '#') {
            dfs(board, word, i + 1, j, index + 1);
        }
        //上
        if (i > 0 && board[i - 1][j] != '#') {
            dfs(board, word, i - 1, j, index + 1);
        }
        //右
        if (j + 1 < col && board[i][j + 1] != '#') {
            dfs(board, word, i, j + 1, index + 1);
        }
        //左
        if (j > 0 && board[i][j - 1] != '#') {
            dfs(board, word, i, j - 1, index + 1);
        }
        //撤销选择
        board[i][j] = temp;
    }
}
