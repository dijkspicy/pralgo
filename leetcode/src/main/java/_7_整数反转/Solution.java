/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package _7_整数反转;

/**
 * auto generated
 *
 * @since 2019-08-31
 */
public class Solution {
    public int reverse(int x) {
        x = Math.abs(x);

        int xTen = 10;
        int div = x / xTen;
        int mod = x % xTen;
        int y = 0;
        while (div != 0) {
            y = y << 1;
            y += mod;

            xTen = xTen * 10;
            div = x / xTen;
            mod = x % xTen;
        }

        boolean isPositive = x >= 0;
        return isPositive ? y : -y;
    }

    public static void main(String[] args) {
        System.out.println(12 / 10);
    }
}
