package com.fan.ali323;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 作者：点点滴滴尽入我心
 * 链接：https://www.nowcoder.com/discuss/389778
 * 来源：牛客网
 * <p>
 * 一个地图n*m，包含1个起点，1个终点，其他点包括可达点和不可达点。 每一次可以：上下左右移动，或使用1点能量从（i,j)瞬间移动到（n-1-i, m-1-j)，最多可以使用5点能量。
 * <p>
 * 1
 * 数据范围：2 <= n,m <= 500;
 * 示例
 * 输入：
 * 4 4
 * #S..
 * E#..
 * ....
 * ....
 * 输出：4
 * 解释:S(0,1)先瞬移到(3, 2)，然后往上一步，往右一步，瞬移到E，一共4步
 */
public class Main02 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;
    static int m;
    static int endX;
    static int endY;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        char[][] map = new char[n][m];
        Queue<Pair> queue = new LinkedList<Pair>();
        for (int i = 0; i < n; i++) {
            map[i] = input.next().toCharArray();
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'S') {
                    Pair pair = new Pair(i, j);
                    queue.add(pair);
                } else if (map[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        }
        System.out.println(BFS(map, queue));
    }

    public static boolean check(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < m)
            return true;
        return false;
    }

    public static int BFS(char[][] map, Queue<Pair> queue) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Pair top = queue.poll();
                if (top.x == endX && top.y == endY) {
                    return top.step;
                }
                for (int i = 0; i < 4; i++) {
                    int curX = top.x + dx[i];
                    int curY = top.y + dy[i];
                    Pair nextPair = new Pair(curX, curY);
                    nextPair.step = top.step + 1;
                    nextPair.fly = top.fly;
                    if (check(curX, curY) && (map[curX][curY] == '.' || map[curX][curY] == 'E')) {
                        queue.add(nextPair);
                        map[curX][curY] = 'X';
                    }
                }
                int flyX = n - 1 - top.x;
                int flyY = m - 1 - top.y;
                if (check(flyX, flyY) && top.fly < 5 && (map[flyX][flyY] == '.' || map[flyX][flyY] == 'E')) {
                    Pair pair = new Pair(flyX, flyY);
                    pair.step = top.step + 1;
                    pair.fly = top.fly + 1;
                    queue.add(pair);
                    map[flyX][flyY] = 'X';
                }
            }
        }
        return -1;
    }
}

class Pair {
    int x;
    int y;
    int step;
    int fly;

    public Pair(int x, int y) {
        // TODO Auto-generated constructor stub
        this.x = x;
        this.y = y;
    }
}
