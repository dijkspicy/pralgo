/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package _992_K个不同整数的子数组;

import com.sun.org.apache.bcel.internal.generic.SIPUSH;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 方法：滑动窗口
 * 思路
 * 方便起见，我们定义子数组：(i,j) = [A[i], A[i+1], ..., A[j]]，并且称一个子数组合法，即它包含K个不同的数字。
 * 对于每一个j，我们考虑包含所有 i的集合Sj，满足子数组 (i, j) 是合法的。
 * 首先， Sj 一定是一个连续的区间。如果 i1 < i2 < i3 且 (i1,j) 与 (i3,j)是合法的，但是 (i2,j) 不合法，这是矛盾的。
 * 因为 (i2,j) 一定包含超过 K 个不同的数字 [因为 (i3,j) 包含 K 个不同的数字，但是 (i1,j) [是 (i2,j) 的一个超集] 却只包含 K 个不同的数字。
 * 所以，让我们将 Sj 写作区间： Sj = [left1j,left2j]。此时，Sj的个数就是left2-left1。
 * 第二个结论是这些区间的端点一定是单调递增的 —— 也就是说left1j和left2j是单调递增的。
 * 与上相似的逻辑，我们也可以构造出这一结论的证明，思路是给现有子数组右端添加一个元素后，要么当前数组依旧合法，要么我们需要在左端删除一些元素使它保持合法。
 * <p>
 * 算法
 * <p>
 * 我们要维护两个滑动窗口以维护left1j和left2j。每一个滑动窗口能够计算窗口内有多少个不同的数字，并且支持像队列一样动态的增加 / 移除元素
 *
 * @since 2019-08-24
 */
public class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        int count = 0;

        Window broadWindow = new Window(A);
        Window narrowWindow = new Window(A);
        int size = A.length;
        while (size-- > 0) {
            broadWindow.slideRight();
            narrowWindow.slideRight();

            // 如果window1超过K，那么window2也必然超过K。但是超过K的时候，其实是包含=K的情况的
            while (broadWindow.getDistinctSize() > K) {
                broadWindow.slideLeft();
                // 此时window1永远是处于刚好等于K的最大集
            }
            while (narrowWindow.getDistinctSize() >= K) {
                narrowWindow.slideLeft();
                // 此时window2永远是处于刚好等于K的最小集
            }

            System.out.println("_" + Arrays.toString(A));
            System.out.println(broadWindow);
            System.out.println(narrowWindow);
            System.out.println("-------------------------------");

            // 每一次处理的宽度差，就是个数，最小0个，最大x个
            // 理论上来说，应该count+=broadWindow.width（1） - narrowWindow.width（2）
            // 但是由于width = right-left+1，故 count+= r1 - l1 - r2 + l2
            // 并且r1=r2，故count+=l2-l1，即narrow.left - broad.left
            count += narrowWindow.getLeft() - broadWindow.getLeft();
        }

        return count;
    }

    private static class Window {
        private final int[] original;
        private int left = 0;
        private int right = 0;

        private int distinctSize = 0;
        private final int[] counter;

        @Override
        public String toString() {
            int max = this.original.length;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.left; i++) {
                sb.append("___");
            }
            sb.append("__" + this.left);
            for (int i = this.left + 1; i < this.right; i++) {
                sb.append("___");
            }
            if (this.right < max) {
                sb.append("__" + this.right);
            }
            return sb.toString();
        }

        private Window(int[] original) {
            this.original = original;
            this.counter = new int[maxOf(original)];
        }

        void slideRight() {
            int value = this.original[this.right++];
            int count = this.counter[value];
            if (count == 0) {
                this.distinctSize++;
            }
            this.counter[value]++;
        }

        void slideLeft() {
            int value = this.original[this.left++];
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

        int getLeft() {
            return left;
        }

        private static int maxOf(int[] args) {
            return 65536;
        }
    }
}
