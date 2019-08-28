package _1_两数之和;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Arrays;

/**
 * auto generated
 *
 * @since 2019-08-28
 */
public class SolutionTest {
    @Test
    public void test1() {
        test(9, new int[] {2, 7, 11, 15}, new int[] {0, 1});
    }

    private void test(int target, int[] nums, int[] result) {
        int[] out = new Solution().twoSum(nums, target);
        assertEquals(Arrays.toString(result), Arrays.toString(out));
    }
}