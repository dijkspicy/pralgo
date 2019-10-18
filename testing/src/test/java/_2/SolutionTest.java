package _2;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test1() {
        System.out.println(new Solution().getMinLengthOfCompleteString(new String[]
                {"time", "me", "bell"}
        ));
    }

    @Test
    public void test2() {
        System.out.println(new Solution().getMinLengthOfCompleteString(new String[]
                {"time", "me", "meet", "bell"}
        ));
    }
}