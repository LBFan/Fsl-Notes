package com.fan.hanshunping.algorithm.dijkstra;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 迪杰斯特拉算法
 * 最短路径
 * @date : 2020/04/16.
 */

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        // 邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        // 表示不可以连接
        final int N = 65535;

        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};


        //创建 Graph 对象
        //测试, 看看图的邻接矩阵是否 ok
        Graph graph = new Graph(vertex, matrix);
        graph.showGraph();
        //测试迪杰斯特拉算法
        //C
        graph.dsj(2);
        graph.showDijkstra();
    }
}


class Graph {
    private char[] vertex; // 顶点数组
    private int[][] matrix; // 邻接矩阵
    private VisitedVertex vv; //已经访问的顶点的集合

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    //显示结果
    public void showDijkstra() {
        vv.show();
    }

    // 显示图
    public void showGraph() {
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));

        }
    }

    /**
     * 迪杰斯特拉算法实现
     *
     * @param index
     */
    public void dsj(int index) {
        vv = new VisitedVertex(vertex.length, index);
        //更新 index 顶点到周围顶点的距离和前驱顶点
        update(index);
        for (int j = 1; j < vertex.length; j++) {
            // 选择并返回新的访问顶点
            index = vv.updateArr();
            // 更新 index 顶点到周围顶点的距离和前驱顶点
            update(index);
        }
    }

    /**
     * 更新 index 下标顶点到周围顶点的距离和周围顶点的前驱顶点
     *
     * @param index
     */
    private void update(int index) {
        int len;
        //根据遍历我们的邻接矩阵的 matrix[index]行
        for (int j = 0; j < matrix[index].length; j++) {
            // len 含义是 : 出发顶点到 index 顶点的距离 + 从 index 顶点到 j 顶点的距离的和
            len = vv.getDis(index) + matrix[index][j];
            // 如果 j 顶点没有被访问过，并且 len 小于出发顶点到 j 顶点的距离，就需要更新
            if (!vv.in(j) && len < vv.getDis(j)) {
                //更新 j 顶点的前驱为 index 顶点
                vv.updatePre(j, index);
                //更新出发顶点到 j 顶点的距
                vv.updateDis(j, len);
            }
        }
    }

}

/**
 * 已访问顶点集合
 */
class VisitedVertex {
    // 记录各个顶点是否访问过 1 表示访问过,0 未访问,会动态更新
    public int[] already_arr;
    // 每个下标对应的值为前一个顶点下标, 会动态更新
    public int[] pre_visited;
    // 记录出发顶点到其他所有顶点的距离,比如 G 为出发顶点，就会记录 G 到其它顶点的距离，会动态更新，求的最短距离就会存放到 dis
    public int[] dis;

    /**
     * @param length :表示顶点的个数
     * @param index: 出发顶点对应的下标, 比如 G 顶点，下标就是 6
     */
    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        //初始化 dis 数组
        Arrays.fill(dis, 65535);
        //设置出发顶点被访问过 this.dis[index] = 0;//设置出发顶点的访问距离为 0
        this.already_arr[index] = 1;

    }

    /**
     * 功能: 判断 index 顶点是否被访问过
     *
     * @param index
     * @return
     */
    public boolean in(int index) {
        return already_arr[index] == 1;
    }

    public void updateDis(int index, int len) {
        dis[index] = len;
    }

    public void updatePre(int pre, int index) {
        pre_visited[pre] = index;
    }

    public int getDis(int index) {
        return dis[index];
    }

    public int updateArr() {
        int min = 65535, index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        //更新 index 顶点被访问过
        already_arr[index] = 1;
        return index;
    }

    public void show() {
        System.out.println("==========================");
        //输出 already_arr
        for (int i : already_arr) {
            System.out.print(i + " ");
        }
        System.out.println(); //输出 pre_visited
        for (int i : pre_visited) {
            System.out.print(i + " ");
        }
        System.out.println(); //输出 dis
        for (
                int i : dis) {
            System.out.print(i + " ");
        }
        System.out.println();
        //为了好看最后的最短距离，我们处理
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int count = 0;
        for (int i : dis) {
            if (i != 65535) {
                System.out.print(vertex[count] + "(" + i + ") ");
            } else {
                System.out.println("N ");
            }
            count++;
        }
        System.out.println();
    }
}
