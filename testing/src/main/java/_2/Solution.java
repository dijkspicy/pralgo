package _2;

import java.util.LinkedList;
import java.util.List;

public class Solution {
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
        List<Integer> indexes = new LinkedList<>();
        indexes.add(0);
        int leftIndex = 0;
        String leftWord = words[0];
        StringBuilder sb = new StringBuilder();
        sb.append(leftWord).append("#");
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            if (leftWord.endsWith(word)) {
                indexes.add(leftWord.indexOf(word) + leftIndex);
            } else {
                indexes.add(sb.length());
                sb.append(word).append("#");
            }
        }
        return sb.length();
    }
}
