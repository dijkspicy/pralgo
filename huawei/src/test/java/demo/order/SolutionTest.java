package demo.order;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void should1() {
        System.out.println(Arrays.deepToString(new Solution().reconstructQueue(new int[][]
                {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}
        )));
    }
}