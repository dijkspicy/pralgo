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
 * <p>
 * *****************************************************************************
 * 首先有个数y
 * 假设y是奇数，那么可以表示为y=2k+1 然后可以表示为k 和 k+1 符合题意
 * 如果y是偶数 那么按题目意思 y = x + x+1 + x+2 +…+x+n y可以表示为 (x+x+n)(n+1)/2=(2x+n)(n+1)/2
 * 现在试想一下
 * 假设n是偶数，那么（n+1）一定是奇数，(2x+n)一定是偶数，
 * 如果n是奇数，那么（n+1）一定是偶数，(2x+n)一定是奇数。结论：y为奇数不讨论（一定是YES），
 * y为偶数则一定是一个奇数和偶数相乘出来的 那么2的n次方 即为 2X2X2X2X2…X2 无论怎么看，都是偶数乘以偶数，不可能出现奇数，所以只要是2的n次方，都是NO
 * 下面贴代码
 * 代码为经典的判断方法，就是按位与运算，因为任何2的n次方都可以表示为1后面n个0 1000… 然后n-1一定是 01111… 然后对位与运算 一定每一位的结果为0
 *
 * @since 2019/8/18
 */
public class Main1 {
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
        // 判断line是2的n次方
        return (line & line - 1) == 0
            ? "NO"
            : "YES";
    }
}
