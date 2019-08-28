package _15_三数之和;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * auto generated
 *
 * @since 2019-08-28
 */
public class SolutionTest {
    @Test
    public void test1() {
        test(new int[] {
            -1, 0, 1, 2, -1, -4
        }, Arrays.asList(
            Arrays.asList(-1, -1, 2),
            Arrays.asList(-1, 0, 1)
        ));
    }

    @Test
    public void test2() {
        test(new int[] {
            -1, 0, 1, 1, -1, 1, -1
        }, Arrays.asList(
            Arrays.asList(-1, 0, 1)
        ));
    }

    private void test(int[] input, List<List<Integer>> result) {
        assertEquals(result.toString(), new Solution().threeSum(input).toString());
    }
}