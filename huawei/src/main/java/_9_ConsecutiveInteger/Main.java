/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package _9_ConsecutiveInteger;

import java.util.Scanner;

/**
 * 题目描述
 * 2005年的百度之星初赛有这么一道题，一个正整数有可能可以被表示为 m(m>1) 个连续正整数之和，如：
 * <p>
 * 15=1+2+3+4+5
 * 15=4+5+6
 * 15=7+8
 * 但现在你的任务是判断给定的整数n能否表示成连续的m(m>1)个正整数之和。
 * <p>
 * 解答要求
 * 时间限制：1000ms, 内存限制：64MB
 * 输入
 * 输入只有一个整数n (1<n<230 +1)。
 * <p>
 * 输出
 * 若n能表示成连续的m(m>1)个正整数之和则输出“YES”，否则输出“NO”。
 * <p>
 * 样例
 * 输入样例 1 复制
 * <p>
 * 15
 * 输出样例 1
 * <p>
 * YES
 *
 * @since 2019/8/18
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int line = scanner.nextInt();
            String out = main0(line);
            if (out != null) {
                System.out.println(out);
            }
        }
    }

    private static String main0(int line) {
        final int middle = line % 2 == 0
            ? line / 2
            : line / 2 + 1;

        for (int i = middle; i > 0; i--) {
            int sum = 0;
            for (int j = i; j > 0; j--) {
                sum += j;
                if (sum == line) {
                    return "YES";
                }
                if (sum > line) {
                    break;
                }
            }
        }
        return "NO";
    }
}
