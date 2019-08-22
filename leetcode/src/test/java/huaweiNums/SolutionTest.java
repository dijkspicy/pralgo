package huaweiNums;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * auto generated
 *
 * @since 2019-08-22
 */
public class SolutionTest {

    @Test
    public void moveZeroes() {
        test(new int[] {
            1, 2, 3, 0, 0, 0, 4, 5, 6,
        }, new int[] {
            1, 2, 3, 4, 5, 6, 0, 0, 0,
        });
    }

    @Test
    public void moveZeroes1() {
        test(new int[] {
            0, 0, 0, 0, 0
        }, new int[] {
            0, 0, 0, 0, 0
        });
    }

    @Test
    public void moveZeroes2() {
        test(new int[] {
            1, 2, 3, 4, 5, 6
        }, new int[] {
            1, 2, 3, 4, 5, 6
        });
    }

    @Test
    public void moveZeroes3() {
        test(new int[] {
            0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 0, 0, 0, 0,
        }, new int[] {
            1, 2, 3, 4, 5, 6, 0, 0, 0, 0, 0, 0, 0, 0,
        });
    }

    private void test(int[] nums, int[] expecteds) {
        new Solution().moveZeroes(nums);
        assertArrayEquals(expecteds, nums);
    }
}