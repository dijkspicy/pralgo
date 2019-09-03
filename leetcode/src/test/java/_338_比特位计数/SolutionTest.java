package _338_比特位计数;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * auto generated
 *
 * @since 2019-08-29
 */
public class SolutionTest {

    @Test
    public void countBits() {
        this.test(2, Arrays.asList(0, 1, 1));
    }

    private void test(int target, List<Integer> bitNums) {
        int[] actual = new Solution().countBits(target);
        List<Integer> list = Arrays.stream(actual)
            .boxed()
            .collect(Collectors.toList());
        assertEquals(bitNums, list);
    }
}