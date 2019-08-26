package _992_K个不同整数的子数组;

import static org.junit.Assert.*;

public class Solution1Test extends SolutionTest {
    @Override
    protected void test(int[] A, int K, int expected) {
        assertEquals(expected, new Solution1().subarraysWithKDistinct(A, K));
    }
}