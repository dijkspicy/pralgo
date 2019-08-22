package huaweiNumsTarget;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * auto generated
 *
 * @since 2019-08-22
 */
public class SolutionTest {
    @Test
    public void test_1() {
        test(new int[] {
            2, 7, 11, 15
        }, 9, new int[] {
            0, 1
        });
    }

    @Test
    public void test_2() {
        test(new int[] {
            1, 2, 3, 5
        }, 5, new int[] {
            1, 2
        });
    }

    @Test
    public void test_3() {
        test(new int[] {
            1, 2, 3, 5
        }, 4, new int[] {
            0, 2
        });
    }

    @Test
    public void test_4() {
        test(new int[] {
            1, 2, 3, 5
        }, 7, new int[] {
            1, 3
        });
    }

    @Test
    public void test_5() {
        test(new int[] {
            1, 2, 3, 5
        }, 8, new int[] {
            2, 3
        });
    }

    private void test(int[] nums, int target, int[] expecteds) {
        assertArrayEquals(expecteds, new Solution().twoSum(nums, target));
    }
}