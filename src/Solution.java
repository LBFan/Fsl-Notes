import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : chars.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        int ans = 0;
        for (String word : words) {
            Map<Character, Integer> wordMap = new HashMap<>();
            for (char w : word.toCharArray()) {
                wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);
            }
            boolean isAns = true;
            for (char w : word.toCharArray()) {
                if (charMap.containsKey(w)) {
                    if (charMap.get(w) < wordMap.get(w)) {
                        isAns = false;
                        break;
                    }
                }

            }
            if (isAns) {
                ans += word.length();
            }
        }
        return ans;
    }

    /**
     * 正方体的表面积
     *
     * @param grid
     * @return
     */
    public int surfaceArea(int[][] grid) {
        // 所有正方体的表面积和 - 共有表面积 x 2
        // 1. 遍历所有的二维数组，求出表面积和

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int sum = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum += grid[i][j];
            }
        }

        // 表面积总和
        sum *= 6;

        // 2. 求出同行的共有表面数
        int rowSum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                rowSum += Math.min(grid[i][j], grid[i][j - 1]);
            }
        }

        rowSum *= 2;

        // 3. 求出同列的共有表面
        int colSum = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 1; j < row; j++) {
                colSum += Math.min(grid[j][i], grid[j - 1][i]);
            }
        }

        colSum *= 2;

        int common = 0;
        // 3. 求出自身堆叠时的共有表面积
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] > 1) {

                    common += (grid[i][j] - 1);
                }
            }
        }
        common *= 2;

        return sum - rowSum - colSum - common;
    }


    /**
     * 999. 车的可用捕获量
     *
     * @param board
     * @return
     */
    public int numRookCaptures(char[][] board) {
        // 1. 判断board
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        // 车的可用捕获数
        int cnt = 0;
        int row = board.length;
        int col = board[0].length;
        // 2. 找出车的位置
        int r = 0, c = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'R') {
                    r = i;
                    c = j;
                    break;
                }
            }
        }
        // 左右找
        if (c == 0) {
            // 向右找
            for (int k = 1; k < col; k++) {
                if (board[r][k] == 'p') {
                    cnt++;
                    break;
                }
                if (board[r][k] == 'B') {
                    break;
                }
            }
        } else if (c == (col - 1)) {
            // 向左找
            for (int k = col - 2; k >= 0; k--) {
                if (board[r][k] == 'p') {
                    cnt++;
                    break;
                }
                if (board[r][k] == 'B') {
                    break;
                }
            }
        } else {
            // 向右找
            for (int i = c + 1; i < col; i++) {
                if (board[r][i] == 'p') {
                    cnt++;
                    break;
                }
                if (board[r][i] == 'B') {
                    break;
                }
            }
            // 从车的位置向左找
            for (int i = c - 1; i >= 0; i--) {
                if (board[r][i] == 'p') {
                    cnt++;
                    break;
                }
                if (board[r][i] == 'B') {
                    break;
                }
            }
        }
        // 上下找

        if (r == 0) {
            // 向下找
            for (int k = 1; k < row; k++) {
                if (board[k][c] == 'p') {
                    cnt++;
                    break;
                }
                if (board[k][c] == 'B') {
                    break;
                }
            }
        } else if (r == (row - 1)) {
            // 向上找
            for (int k = row - 2; k >= 0; k--) {
                if (board[k][c] == 'p') {
                    cnt++;
                    break;
                }
                if (board[k][c] == 'B') {
                    break;
                }
            }
        } else {
            // 从车的位置向下找
            for (int i = r + 1; i < row; i++) {
                if (board[i][c] == 'p') {
                    cnt++;
                    break;
                }
                if (board[i][c] == 'B') {
                    break;
                }
            }
            // 从车的位置向上找
            for (int i = r - 1; i >= 0; i--) {
                if (board[i][c] == 'p') {
                    cnt++;
                    break;
                }
                if (board[i][c] == 'B') {
                    break;
                }
            }
        }

        return cnt;
    }


    String[] res;
    int a = 0;

    public String[] permutation(String S) {
        int max = calculate(S.length());
        res = new String[max];
        process(S.toCharArray(), 0);
        // qwe
        return res;
    }

    public void process(char[] arr, int j) {
        if (j == arr.length) {
            res[a++] = new String(arr);
            return;
        }
        for (int i = j; i < arr.length; i++) {
            swap(arr, i, j);
            process(arr, j + 1);
            swap(arr, i, j);
        }
    }

    public void swap(char[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int calculate(int length) {
        if (length <= 2) {
            return length;
        }
        return length * calculate(length - 1);
    }
}