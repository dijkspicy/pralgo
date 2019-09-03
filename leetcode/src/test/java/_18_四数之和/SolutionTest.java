package _18_四数之和;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * auto generated
 *
 * @since 2019-08-29
 */
public class SolutionTest {

    @Test
    public void fourSum() {
        this.test(0, new int[] {1, 0, -1, 0, -2, 2}, Arrays.asList(
            Arrays.asList(-2, -1, 1, 2),
            Arrays.asList(-2, 0, 0, 2),
            Arrays.asList(-1, 0, 0, 1)
        ));
    }

    @Test
    public void fourSum_1() {
        this.test(-1, new int[] {-1, 0, 1, 2, -1, -4}, Arrays.asList(
            Arrays.asList(-4, 0, 1, 2),
            Arrays.asList(-1, -1, 0, 1)
        ));
    }

    @Test
    public void fourSum_2() {
        this.test(-11, new int[] {1, -2, -5, -4, -3, 3, 3, 5}, Arrays.asList(
            Arrays.asList(-5, -4, -3, 1)
        ));
    }

    @Test
    public void fourSum_3() {
        this.test(-11, new int[] {1, -2, -5, -4, -3, 3, 3, 5}, Arrays.asList(
            Arrays.asList(-5, -4, -3, 1)
        ));
    }

    private void test(int target, int[] input, List<List<Integer>> expect) {
        Assert.assertEquals(expect, new Solution().fourSum(input, target));
    }
}