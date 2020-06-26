package com.fan.zuoalgorithm.cha04;

/**
 * @author :  PF_23
 * @Description : 信封嵌套问题
 * @date : 2020/03/21.
 */

public class Num08 {
    public int maxEnvelopes(int[][] matrix) {
        Envelope[] envelopes = EnvelopeComparator.getSortedEnvelopes(matrix);
        int[] ends = new int[matrix.length];
        ends[0] = envelopes[0].wid;
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 0; i < envelopes.length; i++) {
            l = 0;
            r = right;
            while (l < r) {
                m = (l + r) / 2;
                if (envelopes[i].wid > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[1] = envelopes[i].wid;
        }
        return right + 1;
    }
}

