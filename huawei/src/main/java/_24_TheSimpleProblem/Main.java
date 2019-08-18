/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package _24_TheSimpleProblem;

import java.util.Scanner;

/**
 * 题目描述
 * <p>
 * Solo上了大学，对数学很感兴趣，有一天他面对数分三，一个Sequence(数列)摆在了他面前，这可难住他了……
 * 序列如下：S(a,k,n)=a+(k+a)+(2k+a)+…+(nk+a)，题目要他对序列求和，但是a、k、n的取值好多，他不知如何是好，于是他决定写个程序……
 * Can you get it?
 * <p>
 * 题目数据范围：
 * <p>
 * 0<=a<=100.
 * 0<=k<=100.
 * 0<=n<=100.
 * 解答要求
 * 时间限制：1000ms, 内存限制：64MB
 * 输入
 * 输入只有一行，包含三个整数a、k和n。
 * <p>
 * 输出
 * 根据输入的a、k和n，输出S(a,k,n)的值。
 * <p>
 * 样例
 * 输入样例 1 复制
 * <p>
 * 1 2 4
 * 输出样例 1
 * <p>
 * 25
 * <p>
 * 提示
 * 样例中a=1，k=2，n=4，则S(a,k,n)=1+3+5+7+9=25。
 *
 * @since 2019/8/18
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int out = main0(a, k, n);
            System.out.println(out);
        }
    }

    /**
     * S(a,k,n)=a+(k+a)+(2k+a)+…+(nk+a)
     */
    private static int main0(int a, int k, int n) {
        int out = (2 * a + n * k) * (n + 1);
        return out / 2;
    }
}
