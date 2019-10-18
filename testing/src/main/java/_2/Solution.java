package _2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * solution of second question
 */
public class Solution {
    /**
     * get min length of more complete string
     *
     * @param words words
     * @return the min length
     */
    public int getMinLengthOfCompleteString(String[] words) {
        if (words.length == 0) {
            return 0;
        }
        if (words.length == 1) {
            return words[0].length() + 1;
        }

        return this.getMinLengthOfMoreThanOneWord(words);
    }

    private int getMinLengthOfMoreThanOneWord(String[] words) {
        List<String> list = new ArrayList<>(Arrays.asList(words));
        list.sort((o1, o2) -> Integer.compare(o2.length(), o1.length()));

        List<String> appended = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (String item : list) {
            boolean found = false;
            for (String s : appended) {
                if (s.endsWith(item)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                stringBuilder.append(item).append("#");
                appended.add(item);
            }
        }
        return stringBuilder.length();
    }
}
