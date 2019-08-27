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
public class Solution2 {
    public int maxDistance(int[][] grid) {
        final int N = grid.length;
        final List<Coordinate> lands = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = grid[i][j];
                Coordinate e = new Coordinate(i, j);
                if (value != 0) {
                    lands.add(e);
                }
            }
        }
        if (lands.size() == N * N || lands.size() == 0) {
            return -1;
        }
        return this.maxDistance(grid, lands, 0);
    }

    // 填海造陆，从陆地开始，每一层往海上延伸，能够延伸到最远的表示离陆地最远
    private int maxDistance(int[][] grid, List<Coordinate> lands, int curr) {
        List<Coordinate> levelPosition = new ArrayList<>();
        for (Coordinate land : lands) {
            if (this.isLeftAnOcean(land.row, land.row - 1, land.col, grid)) {
                levelPosition.add(new Coordinate(land.row - 1, land.col));
                grid[land.row - 1][land.col] = 1;
            }
            if (this.isRightAnOcean(grid, land)) {
                levelPosition.add(new Coordinate(land.row + 1, land.col));
                grid[land.row + 1][land.col] = 1;
            }
            if (this.isTopAnOcean(land.col, land.row, land.col - 1, grid)) {
                levelPosition.add(new Coordinate(land.row, land.col - 1));
                grid[land.row][land.col - 1] = 1;
            }
            if (this.isDownAnOcean(grid, land)) {
                levelPosition.add(new Coordinate(land.row, land.col + 1));
                grid[land.row][land.col + 1] = 1;
            }
        }
        if (levelPosition.size() == 0) {
            return curr;
        }
        return maxDistance(grid, levelPosition, curr + 1);
    }

    private boolean isDownAnOcean(int[][] grid, Coordinate land) {
        return land.col + 1 < grid[0].length && grid[land.row][land.col + 1] != 1;
    }

    private boolean isTopAnOcean(int col, int row, int i, int[][] grid) {
        return col - 1 >= 0 && grid[row][i] != 1;
    }

    private boolean isRightAnOcean(int[][] grid, Coordinate land) {
        return land.row + 1 < grid.length && grid[land.row + 1][land.col] != 1;
    }

    private boolean isLeftAnOcean(int row, int i, int col, int[][] grid) {
        return row - 1 >= 0 && grid[i][col] != 1;
    }

    static class Coordinate {
        private final int row;
        private final int col;

        Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Coordinate(" + this.row + "," + this.col + ")";
        }

        int distanceFrom(Coordinate coordinate) {
            return Math.abs(this.row - coordinate.row) + Math.abs(this.col - coordinate.col);
        }
    }
}
