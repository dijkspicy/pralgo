/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package _13_Table;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 题目描述
 * 上图是一个Mysql查询结果图，我们看到这个表格非常漂亮，只需要使用”+”和”-”两个符号就可以打印，现在你的任务是打印一个n×m的表格我们定义单位长度（水平方向有三个”-”，竖直方向有一个”| ”，”|”对齐”+”）的矩形表格为
 * <p>
 * 解答要求
 * 时间限制：1000ms, 内存限制：64MB
 * 输入
 * 输入只有一行包含两个整数n和m(0<n,m<13)。
 * <p>
 * 输出
 * 输出n×m的表格。
 * <p>
 * 样例
 * 输入样例 1 复制
 * <p>
 * 1 1
 * 输出样例 1
 * <p>
 * +---+
 * |   |
 * +---+
 * <p>
 * 输入样例 2 复制
 * <p>
 * 1 2
 * 输出样例 2
 * <p>
 * +---+---+
 * |   |   |
 * +---+---+
 *
 * @since 2019/8/18
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String out = main0(n, m);
            if (out != null) {
                System.out.println(out);
            }
        }
    }

    private static String main0(int row, int column) {
        StringJoiner rowUpperJoiner = new StringJoiner("---");
        StringJoiner rowInnerJoiner = new StringJoiner("   ");
        for (int i = 0; i < column + 1; i++) {
            rowUpperJoiner.add("+");
            rowInnerJoiner.add("|");
        }
        String snEdge = rowUpperJoiner.toString();
        String ewEdge = rowInnerJoiner.toString();
        for (int i = 0; i < row; i++) {
            System.out.println(snEdge);
            System.out.println(ewEdge);
        }
        System.out.println(snEdge);
        return null;
    }
}
