/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package _19_NPlus;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 题目描述
 * Given an integer N(0 ≤ N ≤ 10000), your task is to calculate N!.
 * <p>
 * 解答要求
 * 时间限制：5000ms, 内存限制：64MB
 * 输入
 * One N in one line.
 * <p>
 * 输出
 * For each N, output N! in one line.
 * <p>
 * 样例
 * 输入样例 1 复制
 * <p>
 * 3
 * 输出样例 1
 * <p>
 * 6
 *
 * @since 2019/8/21
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int line = scanner.nextInt();
            Number out = main0(line);
            System.out.println(out);
        }
    }

    private static Number main0(int line) {
        if (line == 0 || line == 1) {
            return 1;
        }
        BigInteger bigInteger = BigInteger.ONE;
        for (int i = 2; i <= line; i++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }
        return bigInteger;
    }
}
