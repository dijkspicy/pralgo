/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package _1162_地图分析;

import java.util.ArrayList;
import java.util.List;

/**
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 * <p>
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 * <p>
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 * @since 2019-08-24
 */
public class Solution1 {
    public int maxDistance(int[][] grid) {
        final int N = grid.length;
        final List<Coordinate> lands = new ArrayList<>();
        final List<Coordinate> oceans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = grid[i][j];
                Coordinate e = new Coordinate(i, j);
                if (value == 0) {
                    oceans.add(e);
                } else {
                    lands.add(e);
                }
            }
        }
        if (lands.size() == N * N || oceans.size() == N * N) {
            return -1;
        }
        return this.maxDistance(lands, oceans);
    }

    private int maxDistance(List<Coordinate> lands, List<Coordinate> oceans) {
        int max = 1;
        for (Coordinate ocean : oceans) {
            int minDistance = Integer.MAX_VALUE;
            for (Coordinate land : lands) {
                int oceanToLandDistance = ocean.distanceFrom(land);
                minDistance = Math.min(minDistance, oceanToLandDistance);
            }
            max = Math.max(max, minDistance);
        }
        return max;
    }

    static class Coordinate {
        private final int x;
        private final int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Coordinate(" + this.x + "," + this.y + ")";
        }

        int distanceFrom(Coordinate coordinate) {
            return Math.abs(this.x - coordinate.x) + Math.abs(this.y - coordinate.y);
        }
    }
}
