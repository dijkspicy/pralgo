/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package _992_K个不同整数的子数组;

import java.util.HashSet;
import java.util.Set;

/**
 * 超时
 *
 * @since 2019-08-24
 */
public class Solution2 {
    public int subarraysWithKDistinct(int[] A, int K) {
        int count = 0;
        for (int start = 0; start < A.length - K + 1; start++) {
            Set<Integer> startToEnd = new HashSet<>();
            for (int end = start + K - 1; end < A.length; end++) {
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
                if (startToEnd.size() > K) {
                    break;
                }
            }
        }
        return count;
    }
}
