package _4两个排序数组的中位数;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * pralgo
 *
 * @author dijkspicy
 * @date 2018/4/14
 */
public class SolutionTest {
    @Test
    public void test() {
        Solution sol = new Solution();
        assertEquals(2.5, sol.findMedianSortedArrays(new int[]{1}, new int[]{2, 3, 4}), 0);
        assertEquals(3, sol.findMedianSortedArrays(new int[]{1, 2, 4, 5}, new int[]{3}), 0);
        assertEquals(2, sol.findMedianSortedArrays(new int[]{1, 2}, new int[]{3}), 0);
        assertEquals(2.5, sol.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 0);
        assertEquals(3.5, sol.findMedianSortedArrays(new int[]{}, new int[]{3, 4}), 0);
        assertEquals(3.5, sol.findMedianSortedArrays(new int[]{3, 4}, new int[]{}), 0);
        assertEquals(3, sol.findMedianSortedArrays(new int[]{3}, new int[]{}), 0);
        assertEquals(0, sol.findMedianSortedArrays(new int[]{}, new int[]{}), 0);
    }
}