/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package _992_K个不同整数的子数组;

import java.util.HashSet;
import java.util.Set;

/**
 * auto generated
 *
 * @since 2019-08-24
 */
public class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        int count = 0;
        for (int windowLength = K; windowLength < A.length; windowLength++) {
            Set<Integer> startToEnd = new HashSet<>();
            for (int start = 0; start < A.length - K + 1; start++) {
                int end = start + windowLength - 1;
                if (startToEnd.size() != 0) {
                    startToEnd.add(A[end]);
                } else {
                    for (int i = start; i <= end; i++) {
                        startToEnd.add(A[i]);
                    }
                }
                if (startToEnd.size() == K) {
                    count++;
                }
                System.out.println(start + "-" + end + ": " + startToEnd);
                if (startToEnd.size() > K) {
                    break;
                }
            }
        }
        return count;
    }
}
