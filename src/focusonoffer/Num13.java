package focusonoffer;

/**
 * @author :  PF_23
 * @Description : 机器人的运动范围
 * 地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，
 * 每一次只能向左右上下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
 * <p>
 * 例如，当 k 为 18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。
 * 但是，它不能进入方格 (35,38)，因为 3+5+3+8=19。请问该机器人能够达到多少个格子？
 * <p>
 * 解题思路
 * 使用深度优先搜索（Depth First Search，DFS）方法进行求解。回溯是深度优先搜索的一种特例，
 * 它在一次搜索过程中需要设置一些本次搜索过程的局部状态，并在本次搜索结束之后清除状态。
 * 而普通的深度优先搜索并不需要使用这些局部状态，虽然还是有可能设置一些全局状态。
 * @date : 2019/12/17.
 */

public class Num13 {
    /**
     * 依次为左、右、上、下
     */
    private static final int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int cnt = 0;
    private int rows;
    private int cols;
    private int threshold;
    private int[][] digitSum;

    public int movingCount(int threshold, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        boolean[][] hasUsed = new boolean[rows][cols];
        initDigitSum();
        dfs(hasUsed, 0, 0);
        return cnt;
    }

    private void dfs(boolean[][] marked, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c]) {
            return;
        }
        marked[r][c] = true;
        if (this.digitSum[r][c] > this.threshold) {
            return;
        }
        cnt++;
        for (int[] d : next) {
            dfs(marked, r + d[0], c + d[1]);
        }
    }

    /**
     * 初始化很有意思
     */
    private void initDigitSum() {
        int[] initDigitSum = new int[Math.max(rows, cols)];
        for (int i = 0; i < initDigitSum.length; i++) {
            int n = i;
            while (n > 0) {
                initDigitSum[i] += n % 10;
                n /= 10;
            }
        }

        digitSum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                digitSum[i][j] = initDigitSum[i] + initDigitSum[j];
            }
        }
    }

    public static void main(String[] args) {
        int threshold = 6;
        int rows = 5;
        int cols = 6;

        Num13 num13 = new Num13();
        int count = num13.movingCount(threshold, rows, cols);
        System.out.println(count);
    }
}


