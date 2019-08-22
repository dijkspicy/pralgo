package huaweiNumsTarget;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import java.util.Arrays;

/**
 * auto generated
 *
 * @since 2019-08-22
 */
public class Solution1Test {
    @Test
    public void test_hashcode_conflict() {
        test(new int[] {
            16384, 2048, 8192, 4096
        }, 12288, new int[] {2, 3});
    }

    @Test
    public void test_8() {
        test(new int[] {
            230, 863, 916, 585, 981, 404, 316, 785, 88, 12, 70, 435, 384, 778, 887, 755, 740, 337, 86, 92, 325, 422,
            815, 650, 920, 125, 277, 336, 221, 847, 168, 23, 677, 61, 400, 136, 874, 363, 394, 199, 863, 997, 794,
            587, 124, 321, 212, 957, 764, 173, 314, 422, 927, 783, 930, 282, 306, 506, 44, 926, 691, 568, 68, 730,
            933, 737, 531, 180, 414, 751, 28, 546, 60, 371, 493, 370, 527, 387, 43, 541, 13, 457, 328, 227, 652, 365,
            430, 803, 59, 858, 538, 427, 583, 368, 375, 173, 809, 896, 370, 789
        }, 1863, new int[] {54, 64});
    }

    @Test
    public void test_7() {
        test(new int[] {
            230, 863, 916, 585, 981, 404, 316, 785, 88, 12, 70, 435, 384, 778, 887, 755, 740, 337, 86, 92, 325, 422,
            815, 650, 920, 125, 277, 336, 221, 847, 168, 23, 677, 61, 400, 136, 874, 363, 394, 199, 863, 997, 794,
            587, 124, 321, 212, 957, 764, 173, 314, 422, 927, 783, 930, 282, 306, 506, 44, 926, 691, 568, 68, 730,
            933, 737, 531, 180, 414, 751, 28, 546, 60, 371, 493, 370, 527, 387, 43, 541, 13, 457, 328, 227, 652, 365,
            430, 803, 59, 858, 538, 427, 583, 368, 375, 173, 809, 896, 370, 789
        }, 542, new int[] {28, 45});
    }

    @Test
    public void test_6() {
        test(new int[] {
            -2, 7, 11, 40962
        }, 40960, new int[] {
            0, 3
        });
    }

    @Test
    public void test_0() {
        test(new int[] {
            -2, 7, 11, 15
        }, 5, new int[] {
            0, 1
        });
    }

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
        int[] actuals = new Solution1().twoSum(nums, target);
        assertArrayEquals(expecteds, actuals);
    }
}