package _1162_地图分析;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * auto generated
 *
 * @since 2019-08-24
 */
public class SolutionTest {
    @Test
    public void test1() {
        test(2, new int[][] {
            {1, 0, 1},
            {0, 0, 0},
            {1, 0, 1}
        });

        test(4, new int[][] {
            {1, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        });
    }

    private void test(int expected, int[][] input) {
        assertEquals(expected, new Solution().maxDistance(input));
    }
}