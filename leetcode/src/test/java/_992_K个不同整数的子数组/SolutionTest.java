package _992_K个不同整数的子数组;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * auto generated
 *
 * @since 2019-08-24
 */
public class SolutionTest {
    @Test
    public void test1() {
        test2(new int[] {
            1, 2, 1, 2, 3
        }, 2, 7);
    }

    @Test
    public void test2() {
        test2(new int[] {
            1, 2, 1, 3, 4
        }, 3, 3);
    }

    @Test
    public void finalTest() throws IOException {
        Path file = Paths.get("src/test/java/_992_K个不同整数的子数组/input360");
        byte[] content = Files.readAllBytes(file);
        String contentString = new String(content);
        contentString = contentString.trim().replaceAll("[\r\n]", "");
        String[] split = contentString.split(",");
        List<Integer> collect = Arrays.stream(split)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        int[] input = new int[collect.size()];
        for (int i = 0; i < collect.size(); i++) {
            input[i] = collect.get(i);
        }

        Instant start = Instant.now();
        try {
            test(input, 360, 10013);
        } finally {
            System.out.println(Duration.between(start, Instant.now()).toMillis());
        }

        start = Instant.now();
        try {
            test1(input, 360, 10013);
        } finally {
            System.out.println(Duration.between(start, Instant.now()).toMillis());
        }
    }

    private void test(int[] A, int K, int expected) {
        assertEquals(expected, new Solution().subarraysWithKDistinct(A, K));
    }

    private void test1(int[] A, int K, int expected) {
        assertEquals(expected, new Solution1().subarraysWithKDistinct(A, K));
    }

    private void test2(int[] A, int K, int expected) {
        assertEquals(expected, new Solution2().subarraysWithKDistinct(A, K));
    }
}