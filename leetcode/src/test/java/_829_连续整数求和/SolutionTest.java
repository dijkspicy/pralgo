package _829_连续整数求和;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * auto generated
 *
 * @since 2019-08-23
 */
public class SolutionTest {

    @Test
    public void consecutiveNumbersSum() {
        test(0, 1);
        test(1, 1);
        test(2, 1);
        test(5, 2);
        test(9, 3);
        test(15, 4);
        test(16, 1);
    }

    private void test(int in, int out) {
        assertEquals(out, new Solution().consecutiveNumbersSum(in));
    }
}