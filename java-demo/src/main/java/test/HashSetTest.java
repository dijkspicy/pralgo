/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * auto generated
 *
 * @since 2019-08-30
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<Integer> left = new HashSet<>(Arrays.asList(1, 2, 3));
        HashSet<Integer> right = new HashSet<>(Arrays.asList(3, 4, 5));
        left.retainAll(right);
        System.out.println(left);
        System.out.println(right);
    }
}
