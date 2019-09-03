package _7_整数反转;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * auto generated
 *
 * @since 2019-08-31
 */
public class SolutionTest {

    @Test
    public void reverse() {
        this.test(321, 123);
        this.test(-321, -123);
        this.test(120, 21);
    }

    private void test(int input, int expect) {
        assertEquals(expect, new Solution().reverse(input));
    }
}