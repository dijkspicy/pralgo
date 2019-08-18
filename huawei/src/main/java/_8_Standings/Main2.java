package _8_Standings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * solo发现他参加Online Judge的比赛表现很不稳定，于是他翻开历史记录，发现他在每一轮的比赛中他的排名R都能被参赛人数N(包括solo)整除，
 * 于是他每次参赛都会先预测他的排名情况，以给自己更大的自信。
 * <p>
 * 解答要求
 * 时间限制：15000ms, 内存限制：64MB
 * 输入
 * 输入只有一个整数N(0<N<109)，代表参赛人数。
 * <p>
 * 输出
 * 在一行输出solo参赛可能的获得的排名数S以及由小到大输出各个排名Ri (0<i ≤ S)，用空格隔开。
 * <p>
 * 样例
 * 输入样例 1 复制
 * <p>
 * 10
 * 输出样例 1
 * <p>
 * 4 1 2 5 10
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int line = scanner.nextInt();
            Object out = main0(line);
            if (out != null) {
                System.out.println(out);
            }
        }
    }

    private static String main0(int line) {
        if (line == 1) {
            return "1 1";
        }

        int middle = line % 2 == 0
            ? line / 2
            : line / 2 + 1;
        int count = 2;
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= middle; i++) {
            if (line % i == 0) {
                count++;
                list.add(i);
            }
        }
        System.out.print(count);
        System.out.print(" " + 1);
        for (Integer integer : list) {
            System.out.print(" " + integer);
        }
        System.out.println(" " + line);
        return null;
    }
}
