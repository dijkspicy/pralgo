/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package _992_K个不同整数的子数组;

/**
 * 方法：滑动窗口
 * 思路
 * 方便起见，我们定义子数组：(i,j) = [A[i], A[i+1], ..., A[j]]，并且称一个子数组 合法 如果它包含 K 个不同的数字。
 * 对于每一个 j，我们考虑包含所有 i 的集合 Sj，满足子数组 (i, j) 是合法的。
 * 首先， Sj 一定是一个连续的区间。如果 i1 < i2 < i3 且 (i1,j) 与 (i3,j)是合法的，但是 (i2,j) 不合法，这是矛盾的。因为 (i2,j) 一定包含超过 K 个不同的数字 [因为 (i3,j) 包含 K 个不同的数字]， 但是 (i1,j) [是 (i2,j) 的一个超集] 却只包含 K 个不同的数字。
 * 所以，让我们将 Sj 写作区间： Sj = [left1j,left2j]。
 * 第二个结论是这些区间的端点一定是单调递增的 —— 也就是说left1j和left2j是单调递增的。与上相似的逻辑，我们也可以构造出这一结论的证明，思路是给现有子数组右端添加一个元素后，要么当前数组依旧合法，要么我们需要在左端删除一些元素使它保持合法。
 *
 * 算法
 *
 * 我们要维护两个滑动窗口以维护left1j和left2j。每一个滑动窗口能够计算窗口内有多少个不同的数字，并且支持像队列一样动态的增加 / 移除元素
 *
 * @since 2019-08-24
 */
public class Solution4 {
    public int subarraysWithKDistinct(int[] A, int K) {
        int count = 0;
        int left1 = 0;
        int left2 = 0;

        Window window1 = new Window();
        Window window2 = new Window();
        for (int value : A) {
            window1.add(value);
            window2.add(value);

            while (window1.getDistinctSize() > K) {
                window1.remove(A[left1++]);
            }
            while (window2.getDistinctSize() >= K) {
                window2.remove(A[left2++]);
            }

            count += left2 - left1;
        }

        return count;
    }

    private static class Window {
        private int distinctSize = 0;
        private final int[] counter = new int[20000];

        void add(int value) {
            int count = this.counter[value];
            if (count == 0) {
                this.distinctSize++;
            }
            this.counter[value]++;
        }

        void remove(int value) {
            int count = this.counter[value];
            if (count > 0) {
                if (count == 1) {
                    this.distinctSize--;
                }
                this.counter[value]--;
            }
        }

        int getDistinctSize() {
            return this.distinctSize;
        }
    }
}
