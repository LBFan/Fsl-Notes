package com.fan.leetcode.graphs.tuopu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/02/18.
 */

public class Num01 {
    /**
     * @author :  PF_23
     * @Description : 课程安排的合法性  拓扑排序范围
     * <p>
     * 2, [[1,0]]
     * return true
     * 2, [[1,0],[0,1]]
     * return false
     * 题目描述：一个课程可能会先修课程，判断给定的先修课程规定是否合法。
     * <p>
     * 本题不需要使用拓扑排序，只需要检测有向图是否存在环即可。
     * @date : 2020/02/18.
     */

    public static class Num02 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] graphic = new List[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graphic[i] = new ArrayList<>();
            }
            for (int[] pre : prerequisites) {
                graphic[pre[0]].add(pre[1]);
            }
            boolean[] globalMarked = new boolean[numCourses];
            boolean[] localMarked = new boolean[numCourses];
            for (int i = 0; i < numCourses; i++) {
                if (hasCycle(globalMarked, localMarked, graphic, i)) {
                    return false;
                }
            }
            return true;
        }

        private boolean hasCycle(boolean[] globalMarked, boolean[] localMarked, List<Integer>[] graphic, int curNode) {
            if (localMarked[curNode]) {
                return true;
            }
            if (globalMarked[curNode]) {
                return false;
            }
            globalMarked[curNode] = true;
            localMarked[curNode] = true;
            for (int nextNode : graphic[curNode]) {
                if (hasCycle(globalMarked, localMarked, graphic, nextNode)) {
                    return true;
                }
            }
            localMarked[curNode] = false;
            return false;
        }
    }
}

