/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package _1162_地图分析;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 * <p>
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 * <p>
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 * @since 2019-08-24
 */
public class Solution {

    private static final int OCEAN = 0;
    private static final int LAND = 1;

    public int maxDistance(int[][] grid) {
        final int N = grid.length;
        final int M = grid[0].length;
        final List<Coordinate> lands = new ArrayList<>();

        // 遍历找到所有的陆地
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = grid[i][j];
                if (value == LAND) {
                    lands.add(new Coordinate(grid, i, j));
                }
            }
        }

        // 如果全部是陆地或者海洋，直接退出
        if (lands.size() == N * M || lands.size() == 0) {
            return -1;
        }
        return this.maxDistance(lands, 0);
    }

    /**
     * 填海造陆，从陆地开始，每一层往海上延伸，能够延伸到最远的表示离陆地最远
     * <p>
     * BFS，从陆地往海洋延伸，测量每一个海洋区域，量过的做一个标记
     * 量完一圈进行一次递归，直到所有的都测量完成
     */
    private int maxDistance(List<Coordinate> lands, int depth) {
        List<Coordinate> measuredLands = new ArrayList<>();
        for (Coordinate land : lands) {
            land.tryMeasureLeftOcean(measuredLands::add);
            land.tryMeasureRightOcean(measuredLands::add);
            land.tryMeasureTopOcean(measuredLands::add);
            land.tryMeasureDownOcean(measuredLands::add);
        }
        if (measuredLands.isEmpty()) {
            return depth;
        }
        return this.maxDistance(measuredLands, ++depth);
    }

    private static class Coordinate {
        private static final int MEASURED = -1;
        private final int[][] original;
        private final int n;
        private final int m;
        private final int x;
        private final int y;

        Coordinate(int[][] original, int x, int y) {
            this.original = original;
            this.n = this.original.length;
            this.m = this.original[0].length;
            this.x = x;
            this.y = y;
        }

        void tryMeasureRightOcean(Consumer<Coordinate> consumeIfMeasured) {
            int newX = this.x + 1;
            int newY = this.y;
            if (newX < this.n && this.original[newX][newY] == OCEAN) {
                this.original[newX][newY] = MEASURED;
                consumeIfMeasured.accept(new Coordinate(this.original, newX, newY));
            }
        }

        void tryMeasureTopOcean(Consumer<Coordinate> consumeIfMeasured) {
            int newX = this.x;
            int newY = this.y - 1;
            if (newY >= 0 && this.original[newX][newY] == OCEAN) {
                this.original[newX][newY] = MEASURED;
                consumeIfMeasured.accept(new Coordinate(this.original, newX, newY));
            }
        }

        void tryMeasureDownOcean(Consumer<Coordinate> consumeIfMeasured) {
            int newX = this.x;
            int newY = this.y + 1;
            if (newY < this.m && this.original[newX][newY] == OCEAN) {
                this.original[newX][newY] = MEASURED;
                consumeIfMeasured.accept(new Coordinate(this.original, newX, newY));
            }
        }

        void tryMeasureLeftOcean(Consumer<Coordinate> consumeIfMeasured) {
            int newX = this.x - 1;
            int newY = this.y;
            if (newX >= 0 && this.original[newX][newY] == OCEAN) {
                this.original[newX][newY] = MEASURED;
                consumeIfMeasured.accept(new Coordinate(this.original, newX, newY));
            }
        }
    }
}
