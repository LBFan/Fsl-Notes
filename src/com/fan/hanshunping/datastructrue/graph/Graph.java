package com.fan.hanshunping.datastructrue.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author :  PF_23
 * @Description : 图
 * @date : 2020/04/15.
 */

public class Graph {
    /**
     * 存储顶点集合
     */
    private ArrayList<String> vertexList;
    /**
     * 存储图对应的邻接矩阵
     */
    private int[][] edges;
    /**
     * 表示边的数目
     */
    private int numOfEdges;
    /**
     * 定义给数组 boolean[], 记录某个结点是否被访问
     */
    private boolean[] isVisited;

    public static void main(String[] args) {
        //测试一把图是否创建 ok
        //结点的个数
        int n = 8;
        //String vertexs[] = {"A", "B", "C", "D", "E"};
        String[] vertexs = {"1", "2", "3", "4", "5", "6", "7", "8"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加顶
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }
        //添加边
        //A-B A-C B-C B-D B-E
        // graph.insertEdge(0, 1, 1); // A-B
        // graph.insertEdge(0, 2, 1); //
        // graph.insertEdge(1, 2, 1); //
        // graph.insertEdge(1, 3, 1); //
        // graph.insertEdge(1, 4, 1); //
        //更新边的关系
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);
//        显示一把邻结矩阵
        graph.showGraph();
//        //测试一把，我们的 dfs 遍历是否 ok
        System.out.println("深度遍历");
        graph.dfs(); // A->B->C->D->E [1->2->4->8->5->3->6->7]
        System.out.println();
        System.out.println("广度优先!");
        graph.bfs(); // A->B->C->D-E [1->2->3->4->5->6->7->8]
    }

    public Graph(int n) {
        //初始化矩阵和 vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
    }

    /**
     * 得到第一个邻接结点的下标 w
     * 如果存在就返回对应的下标，否则返回-1
     *
     * @param index 当前结点下标
     * @return
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接结点的下标来获取下一个邻接结点
     *
     * @param v1 当前结点
     * @param v2 当前结点的前一个邻接结点
     * @return v1的下一个邻接结点
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 对 dfs 进行一个重载, 遍历我们所有的结点，并进行 dfs
     */
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        //遍历所有的结点，进行 dfs[回溯]
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    /**
     * 深度优先遍历算法 i 第一次就是 0
     *
     * @param isVisited
     * @param i
     */
    private void dfs(boolean[] isVisited, int i) {
        //首先我们访问该结点,输出
        System.out.print(getValueByIndex(i) + "->");
        //将结点设置为已经访问
        isVisited[i] = true;
        //查找结点 i 的第一个邻接结点 w
        int w = getFirstNeighbor(i);
        while (w != -1) {
            //说明有
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            // 这里体现了深度优先遍历的回溯：到这里说明已经深度遍历完（i，w）的深度邻接结点，
            // 现在回溯到（i，w)得下一个邻接结点继续深度遍历
            //如果 w 结点已经被访问过
            w = getNextNeighbor(i, w);
        }
    }

    /**
     * 遍历所有的结点，都进行广度优先搜索
     */
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    /**
     * 对一个结点进行广度优先遍历的方法
     *
     * @param isVisited
     * @param i
     */
    private void bfs(boolean[] isVisited, int i) {
        int u; // 表示队列的头结点对应下标
        int w; // 邻接结点 w
        // 队列，记录结点访问的顺序
        LinkedList queue = new LinkedList();
        //访问结点，输出结点信息
        System.out.print(getValueByIndex(i) + "=>");
        //标记为已访问
        isVisited[i] = true;
        //将结点加入队列
        queue.addLast(i);
        while (!queue.isEmpty()) {
            //取出队列的头结点下标
            u = (Integer) queue.removeFirst();
            //得到第一个邻接结点的下标 w
            w = getFirstNeighbor(u);
            while (w != -1) {
                //找到
                //是否访问过
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "=>");
                    //标记已经访问
                    isVisited[w] = true;
                    //入队
                    queue.addLast(w);
                }
                //以 u 为前驱点，找 w 后面的下一个邻结点
                //体现出我们的广度优先
                w = getNextNeighbor(u, w);
            }
        }
    }

    /**
     * 返回结点的个数
     *
     * @return
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //显示图对应的矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }


    //得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点 i(下标)对应的数据 0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //添加边

    /**
     * @param v1     表示点的下标即第几个顶点
     * @param v2     第二个顶点对应的下标
     * @param weight 表示v1和v2的路径权值
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}


