package hanshunping.algorithm.kruskal;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : kruskal算法
 * 克鲁斯卡尔(Kruskal)算法，是用来求加权连通图的最小生成树的算法
 * <p>
 * 基本思想:按照权值从小到大的顺序选择n-1条边，并保证这n-1条边不构成回路
 * <p>
 * 具体做法:首先构造一个只含n个顶点的森林，然后依权值从小到大从连通网中选择边加入到森林中，并使森
 * 林中不产生回路，直至森林变成一棵树为止
 * @date : 2020/04/16.
 */

public class KruskalCase {
    private int edgeNum; //边的个数
    private char[] vertexs; //顶点数组
    private int[][] matrix; //邻接矩阵
    //使用 INF 表示两个顶点不能连通
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = { /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/{0, 12, INF, INF, INF, 16, 14},
                /*B*/{12, 0, 10, INF, INF, 7, INF},
                /*C*/{INF, 10, 0, 3, 5, 6, INF},
                /*D*/{INF, INF, 3, 0, 4, INF, INF},
                /*E*/{INF, INF, 5, 4, 0, 2, 8},
                /*F*/{16, 7, 6, INF, 2, 0, 9},
                /*G*/{14, INF, INF, INF, 8, 9, 0}

        };
        //大家可以在去测试其它的邻接矩阵，结果都可以得到最小生成树.
        //创建 KruskalCase 对象实例
        //输出构建的
        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
        kruskalCase.print();
        kruskalCase.kruskal();
    }

    public KruskalCase(char[] vertexs, int[][] matrix) {
        //初始化顶点数和边的个数
        int vlen = vertexs.length;
        //初始化顶点, 复制拷贝的方式
        this.vertexs = new char[vlen];
        for (int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }
        //初始化边, 使用的是复制拷贝的方式
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }

        //统计边的条数
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public void kruskal() {
        //表示最后结果数组的索引
        int index = 0;
        //用于保存"已有最小生成树" 中的每个顶点在最小生成树中的终点 //创建结果数组, 保存最后的最小生成树
        int[] ends = new int[edgeNum];
        EData[] rets = new EData[edgeNum];
        //获取图中 所有的边的集合 ， 一共有 12 边
        EData[] edges = getEdges();
        //12
        System.out.println("图的边的集合=" + Arrays.toString(edges) + " 共" + edges.length);
        //按照边的权值大小进行排序(从小到大)
        sortEdges(edges);
        //遍历 edges 数组，将边添加到最小生成树中时，判断是准备加入的边否形成了回路，如果没有，就加入 rets, 否则不能加入
        for (int i = 0; i < edgeNum; i++) {
            //获取到第 i 条边的第一个顶点(起点)
            //p1=4 //获取到第 i 条边的第 2 个顶点
            int p1 = getPosition(edges[i].start);
            //p2 = 5
            int p2 = getPosition(edges[i].end);
            //获取 p1 这个顶点在已有最小生成树中的终点
            //m = 4
            int m = getEnd(ends, p1);
            //获取 p2 这个顶点在已有最小生成树中的终点
            // n = 5
            int n = getEnd(ends, p2);
            //是否构成回路
            if (m != n) {
                //没有构成回路
                // 设置 m 在"已有最小生成树"中的终点 <E,F> [0,0,0,0,5,0,0,0,0,0,0,0]
                ends[m] = n;
                //有一条边加入到 rets 数组
                rets[index++] = edges[i];
            }
        }
        //<E,F> <C,D> <D,E> <B,F> <E,G> <A,B>。 //统计并打印 "最小生成树", 输出 rets
        System.out.println("最小生成树为");
        for (int i = 0; i < index; i++) {
            System.out.println(rets[i]);
        }
    }

    //打印邻接矩阵
    public void print() {
        System.out.println("邻接矩阵为: \n");
        for (
                int i = 0;
                i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();//换
        }
    }

    private void sortEdges(EData[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    //交换
                    EData tmp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = tmp;
                }
            }
        }
    }

    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                //找到
                return i;
            }
        }
        //找不到,返回-1
        return -1;
    }

    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    private int getEnd(int[] ends, int i) { // i = 4 [0,0,0,0,5,0,0,0,0,0,0,0]
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }
}

class EData {
    char start; //边的一个点
    char end; //边的另外一个点
    int weight; //边的权值

    //构造器
    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    //重写 toString, 便于输出边信息 @Override
    @Override
    public String toString() {
        return "EData [<" + start + ", " + end + ">= " + weight + "]";
    }
}
