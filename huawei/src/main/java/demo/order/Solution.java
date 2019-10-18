package demo.order;

import java.util.*;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，
 * 其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * <p>
 * 注意：
 * 总人数少于1100人。
 * <p>
 * 示例
 * <p>
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<Person> sorted = new ArrayList<>();
        for (int[] it : people) {
            Person person = new Person(it[0], it[1]);
            sorted.add(person);
        }
        Collections.sort(sorted);
        int[][] sortedArray = new int[sorted.size()][];
        int index = 0;
        for (Person person : sorted) {
            sortedArray[index++] = new int[]{person.h, person.k};
        }
        return sortedArray;
    }

    static class Person implements Comparable<Person> {
        int h;
        int k;

        public Person(int h, int k) {
            this.h = h;
            this.k = k;
        }

        @Override
        public int compareTo(Person o) {
            if (o == this) {
                return 0;
            }
            if (this.h == o.h) {
                return Integer.compare(this.k, o.k);
            }

            if (this.h + this.k != o.h + o.k) {
                return Integer.compare(this.h + this.k, o.h + o.k);
            }

            return Integer.compare(this.h, o.h);
        }
    }
}
