/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package _1160_拼写单词;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * <p>
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * <p>
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * <p>
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 * @since 2019-08-24
 */
public class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> lexMap = this.lexMap(chars);

        int size = 0;
        for (String word : words) {
            if (word.length() > chars.length()) {
                continue;
            }

            boolean matches = true;
            Map<Character, Integer> temp = new HashMap<>();
            for (char c : word.toCharArray()) {
                // 不包含
                if (!lexMap.containsKey(c)) {
                    matches = false;
                    break;
                }

                Integer integer = temp.get(c);
                if (integer == null) {
                    temp.put(c, 1);
                } else {
                    Integer value = ++integer;
                    if (value > lexMap.get(c)) {
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

    private Map<Character, Integer> lexMap(String chars) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : chars.toCharArray()) {
            Integer integer = countMap.get(c);
            if (integer == null) {
                countMap.put(c, 1);
            } else {
                countMap.put(c, ++integer);
            }
        }
        return countMap;
    }
}
