package leetcode.graphs.tuopu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 课程安排的顺序
 * <p>
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * There are a total of 4 courses to take.
 * To take course 3 you should have finished both courses 1 and 2.
 * Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 * <p>
 * 使用 DFS 来实现拓扑排序，使用一个栈存储后序遍历结果，这个栈的逆序结果就是拓扑排序结果。
 * <p>
 * 证明：对于任何先序关系：v->w，后序遍历结果可以保证 w 先进入栈中，因此栈的逆序结果中 v 会在 w 之前。
 * @date : 2020/02/18.
 */

public class Num02 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graphic = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graphic[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            graphic[pre[0]].add(pre[1]);
        }
        Stack<Integer> postOrder = new Stack<>();
        boolean[] globalMarked = new boolean[numCourses];
        boolean[] localMarked = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(globalMarked, localMarked, graphic, i, postOrder)) {
                return new int[0];
            }
        }
        int[] orders = new int[numCourses];
        for (int i = numCourses - 1; i >= 0; i--) {
            orders[i] = postOrder.pop();
        }
        return orders;
    }

    private boolean hasCycle(boolean[] globalMarked, boolean[] localMarked, List<Integer>[] graphic,
                             int curNode, Stack<Integer> postOrder) {
        if (localMarked[curNode]) {
            return true;
        }
        if (globalMarked[curNode]) {
            return false;
        }
        globalMarked[curNode] = true;
        localMarked[curNode] = true;
        for (int nextNode : graphic[curNode]) {
            if (hasCycle(globalMarked, localMarked, graphic, nextNode, postOrder)) {
                return true;
            }
        }
        localMarked[curNode] = false;
        postOrder.push(curNode);
        return false;
    }
}

