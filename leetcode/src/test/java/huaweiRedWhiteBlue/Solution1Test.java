package huaweiRedWhiteBlue;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * auto generated
 *
 * @since 2019-08-22
 */
public class Solution1Test {
    @Test
    public void test_1() {
        test(new int[] {
            2, 0, 2, 1, 1, 0
        }, new int[] {
            0, 0, 1, 1, 2, 2
        });
    }

    @Test
    public void test_2() {
        test(new int[] {
            0, 0, 0
        }, new int[] {
            0, 0, 0
        });
    }

    @Test
    public void test_3() {
        test(new int[] {
            1, 1, 1
        }, new int[] {
            1, 1, 1
        });
    }

    private void test(int[] original, int[] expecteds) {
        new Solution1().sortColors(original);
        assertArrayEquals(expecteds, original);
    }
}