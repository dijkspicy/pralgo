package _1;

import java.util.ArrayList;
import java.util.List;

/**
 * solution of first question
 */
public class Solution {
    private static final int TOTAL_LENGTH = 101;
    private static final int MAX_INDEX = 100;
    private static final int WEST = -1;
    private static final int EAST = 1;

    /**
     * most visited in link
     *
     * @param transmissionRecords transmission records
     * @return a most visited value of transmission records
     */
    public int mostVisited(int[][] transmissionRecords) {
        List<DataItem> items = new ArrayList<>();
        for (int[] transmissionRecord : transmissionRecords) {
            items.add(new DataItem(transmissionRecord[0], transmissionRecord[1]));
        }

        return this.mostVisited(items);
    }

    private int mostVisited(List<DataItem> items) {
        int[] posCount = new int[TOTAL_LENGTH];
        for (int i = 0; i <= MAX_INDEX; i++) {
            posCount[i] = 0;
        }
        for (DataItem item : items) {
            if (item.value == WEST) {
                for (int i = 0; i <= item.pos; i++) {
                    posCount[i]++;
                }
            } else if (item.value == EAST) {
                for (int i = MAX_INDEX; i >= item.pos; i--) {
                    posCount[i]++;
                }
            }
        }
        int index = 0;
        int maxValue = posCount[index];
        for (int i = 1; i < TOTAL_LENGTH; i++) {
            if (posCount[i] > maxValue) {
                index = i;
                maxValue = posCount[index];
            }
        }
        return index;
    }

    /**
     * data item of link
     */
    private static class DataItem {
        int pos;
        int value;

        /**
         * constructor of data item
         *
         * @param pos pos
         * @param value value
         */
        DataItem(int pos, int value) {
            this.pos = pos;
            this.value = value;
        }
    }
}
