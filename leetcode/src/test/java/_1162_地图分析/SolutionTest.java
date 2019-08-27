package _1162_地图分析;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;

/**
 * auto generated
 *
 * @since 2019-08-24
 */
public class SolutionTest {
    @Test
    public void test1() {
        test(2, new int[][] {
            {1, 0, 1},
            {0, 0, 0},
            {1, 0, 1}
        });
    }

    @Test
    public void test2() {
        test(4, new int[][] {
            {1, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        });
    }

    @Test
    public void test3() {
        int[][] inputs = readFromFile("input1");
        Instant start = Instant.now();
        try {
            test(3, inputs);
        } finally {
            System.out.println(Duration.between(start, Instant.now()).toMillis());
        }
    }

    protected void test(int expected, int[][] input) {
        assertEquals(expected, new Solution().maxDistance(input));
    }

    private int[][] readFromFile(String fileName) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(Paths.get("src/test/java/_1162_地图分析/" + fileName).toFile(), new TypeReference<int[][]>() { });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new int[0][];
    }
}