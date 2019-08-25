/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package _992_K个不同整数的子数组;

/**
 * 超时
 *
 * @since 2019-08-24
 */
public class Solution1 {
    public int subarraysWithKDistinct(int[] A, int K) {
        int count = 0;
        for (int start = 0; start < A.length - K + 1; start++) {
            Window window = new Window();
            int end = start + K - 1;
            for (int i = start; i <= end; i++) {
                window.add(A[i]);
            }
            for (; end < A.length; end++) {
                window.add(A[end]);
                if (window.getDistinctCount() == K) {
                    count++;
                }
                if (window.getDistinctCount() > K) {
                    break;
                }
            }
        }
        return count;
    }

    private static class Window {
        private final int[] counter = new int[65536];
        private int distinctCount = 0;

        void add(int value) {
            this.counter[value]++;
            if (this.counter[value] == 1) {
                this.distinctCount++;
            }
        }

        void remove(int value) {
            if (this.counter[value] > 0) {
                this.counter[value]--;
            }
            if (this.counter[value] == 0) {
                this.distinctCount--;
            }
        }

        int getDistinctCount() {
            return this.distinctCount;
        }
    }
}
