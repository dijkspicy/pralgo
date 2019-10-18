package _1;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test1() {
        System.out.println(new Solution().mostVisited(new int[][]
                {{3, -1}, {2, -1}, {5, 1}}
        ));
    }

    @Test
    public void test2() {
        System.out.println(new Solution().mostVisited(new int[][]
                {{1,1},{2,1},{3,-1},{1,-1},{1,1}}
        ));
    }
}