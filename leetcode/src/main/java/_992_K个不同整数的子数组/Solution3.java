/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package _992_K个不同整数的子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * auto generated
 *
 * @since 2019-08-24
 */
public class Solution3 {
    public int subarraysWithKDistinct(int[] A, int K) {
        Window window1 = new Window();
        Window window2 = new Window();
        int count = 0;
        int left1 = 0;
        int left2 = 0;

        for (int x : A) {
            window1.add(x);
            window2.add(x);

            while (window1.different() > K) {
                window1.remove(A[left1++]);
            }
            while (window2.different() >= K) {
                window2.remove(A[left2++]);
            }

            count += left2 - left1;
        }

        return count;
    }

    private static class Window {
        private final Map<Integer, Integer> count;
        private int nonzero;

        Window() {
            count = new HashMap<>();
            nonzero = 0;
        }

        void add(int x) {
            count.put(x, count.getOrDefault(x, 0) + 1);
            if (count.get(x) == 1) {
                nonzero++;
            }
        }

        void remove(int x) {
            count.put(x, count.get(x) - 1);
            if (count.get(x) == 0) {
                nonzero--;
            }
        }

        int different() {
            return nonzero;
        }
    }
}
