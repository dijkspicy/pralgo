/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package _992_K个不同整数的子数组;

/**
 * auto generated
 *
 * @since 2019-08-24
 */
public class Solution1 {
    public int subarraysWithKDistinct(int[] A, int K) {
        int count = 0;
        for (int start = 0; start < A.length - K + 1; start++) {
            int[] sets = new int[65536];
            int currentCount = 0;
            for (int end = start + K - 1; end < A.length; end++) {
                if (currentCount != 0) {
                    int hash = A[end];
                    if (sets[hash] == 0) {
                        currentCount++;
                    }
                    sets[hash] = A[end];
                } else {
                    for (int i = start; i <= end; i++) {
                        int hash = A[i];
                        if (sets[hash] == 0) {
                            currentCount++;
                        }
                        sets[hash] = A[i];
                    }
                }
                if (currentCount == K) {
                    count++;
                }
                if (currentCount > K) {
                    break;
                }
            }
        }
        return count;
    }

}
