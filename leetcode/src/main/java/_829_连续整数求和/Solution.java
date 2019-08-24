/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package _829_连续整数求和;

/**
 * 给定一个正整数 N，试求有多少组连续正整数满足所有数字之和为 N?
 * <p>
 * 示例 1:
 * <p>
 * 输入: 5
 * 输出: 2
 * 解释: 5 = 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
 * 示例 2:
 * <p>
 * 输入: 9
 * 输出: 3
 * 解释: 9 = 9 = 4 + 5 = 2 + 3 + 4
 * 示例 3:
 * <p>
 * 输入: 15
 * 输出: 4
 * 解释: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 * 说明: 1 <= N <= 10 ^ 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/consecutive-numbers-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @since 2019-08-23
 */
public class Solution {
    public int consecutiveNumbersSum(int N) {
        if (N <= 2) {
            return 1;
        }
        int count = 0;
        int N2 = N * 2;
        int upper = (int) Math.ceil(Math.sqrt(N2));
        for (int i = 1; i < upper; i++) {
            int mod = N2 % i;
            int quotient = N2 / i;
            if (N2 % i == 0) {
                if (quotient % 2 + i % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
