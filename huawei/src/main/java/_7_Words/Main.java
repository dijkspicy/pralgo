/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2012-2018. All rights reserved.
 */

package _7_Words;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * 题目描述
 * 每个句子由多个单词组成，句子中的每个单词的长度都可能不一样，我们假设每个单词的长度Ni为该单词的重量，你需要做的就是给出整个句子的平均重量V。
 * <p>
 * 解答要求
 * 时间限制：1000ms, 内存限制：64MB
 * 输入
 * 输入只有一行，包含一个字符串S(长度不会超过100)，代表整个句子，句子中只包含大小写的英文字母，每个单词之间有一个空格。
 * <p>
 * 输出
 * 输出句子S的平均重量V(四舍五入保留两位小数)。
 * <p>
 * 样例
 * 输入样例 1 复制
 * <p>
 * Who Love Solo
 * 输出样例 1
 * <p>
 * 3.67
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String out = main0(line);
            System.out.println(out);
        }
    }

    private static String main0(String line) {
        String[] split = line.split("\\s+");
        int length = split.length;
        if (length == 0) {
            return render(0);
        }
        if (length == 1) {
            return render(split[0].length());
        }
        Integer reduce = Arrays.stream(split)
            .map(String::length)
            .reduce(0, Integer::sum);
        return render((double) reduce / length);
    }

    private static String render(double length) {
        return String.format(Locale.ENGLISH, "%.2f", length);
    }
}
