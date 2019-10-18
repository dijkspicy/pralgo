package _1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int mostVisited(int[][] transmissionRecords) {
        List<DataItem> items = new ArrayList<>();
        for (int[] transmissionRecord : transmissionRecords) {
            items.add(new DataItem(transmissionRecord[0], transmissionRecord[1]));
        }

        return this.mostVisited(items);
    }

    private int mostVisited(List<DataItem> items) {
        int[] posCount = new int[101];
        for (int i = 0; i <= 100; i++) {
            posCount[i] = 0;
        }
        for (DataItem item : items) {
            if (item.value == -1) {
                for (int i = 0; i <= item.pos; i++) {
                    posCount[i]++;
                }
            } else if (item.value == 1) {
                for (int i = 100; i >= item.pos; i--) {
                    posCount[i]++;
                }
            }
        }
        int index = 0;
        int maxValue = posCount[index];
        for (int i = 1; i < 101; i++) {
            if (posCount[i] > maxValue) {
                index = i;
                maxValue = posCount[index];
            }
        }
        return index;
    }

    private static class DataItem {
        int pos;
        int value;

        public DataItem(int p, int v) {
            this.pos = p;
            this.value = v;
        }
    }
}