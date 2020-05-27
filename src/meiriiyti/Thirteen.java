package meiriiyti;

/**
 * @author :  PF_23
 * @Description : 机器人运动范围
 * 数位和增量公式：
 * 设i的数位和为si,i+ 1的数位和为si + 1
 * 1:当（i+ 1）% 10 == 0时，Si+ 1 = Si - 8,例如 19, 20 的数位和分别为 10,2
 * 2:当（i+ 1）% 10 != 0时，Si+1 = Si + 1,例如 1, 2 的数位和分别为 1, 2
 * @date : 2020/04/08.
 */

public class Thirteen {
    int m, n, k;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    private int dfs(int i, int j, int si, int sj) {
        if (i < 0 || i >= m || j < 0 || j >= n || k < si + sj || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }
}

