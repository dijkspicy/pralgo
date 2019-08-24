/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package _1160_拼写单词;

import java.util.HashMap;
import java.util.Map;

/**
 * auto generated
 *
 * @since 2019-08-24
 */
public class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : chars.toCharArray()) {
            Integer integer = countMap.get(c);
            if (integer == null) {
                countMap.put(c, 1);
            } else {
                countMap.put(c, ++integer);
            }
        }

        int size = 0;
        for (String word : words) {
            if (word.length() > chars.length()) {
                continue;
            }

            boolean matches = true;
            Map<Character, Integer> temp = new HashMap<>();
            for (char c : word.toCharArray()) {
                if (!countMap.containsKey(c)) {
                    matches = false;
                    break;
                }

                Integer integer = temp.get(c);
                if (integer == null) {
                    temp.put(c, 1);
                } else {
                    Integer value = ++integer;
                    if (value > countMap.get(c)) {
                        matches = false;
                        break;
                    }
                    temp.put(c, value);
                }
            }


            if (matches) {
                size += word.length();
            }
        }
        return size;
    }
}
