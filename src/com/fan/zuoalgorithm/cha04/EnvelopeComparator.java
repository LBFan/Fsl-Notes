package com.fan.zuoalgorithm.cha04;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/03/21.
 */

public class EnvelopeComparator implements Comparator<Envelope> {
    @Override
    public int compare(Envelope o1, Envelope o2) {
        return o1.len != o2.len ? o1.len - o2.len : o2.wid - o1.wid;
    }

    public static Envelope[] getSortedEnvelopes(int[][] matrix) {
        Envelope[] res = new Envelope[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            res[i] = new Envelope(matrix[i][0], matrix[i][1]);
        }
        Arrays.sort(res, new EnvelopeComparator());
        return res;
    }
}

