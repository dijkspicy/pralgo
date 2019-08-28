/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package test;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * auto generated
 *
 * @since 2019-08-28
 */
public class AtomicBooleanTest {
    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        System.out.println(atomicBoolean); // default false

        atomicBoolean.set(false);
        System.out.println(atomicBoolean.compareAndSet(false, true)); // true, because success

        atomicBoolean.set(false);
        System.out.println(atomicBoolean.compareAndSet(true, false)); // false, because failed

        atomicBoolean.set(true);
        System.out.println(atomicBoolean.compareAndSet(true, false)); // true, because success

        atomicBoolean.set(true);
        System.out.println(atomicBoolean.compareAndSet(false, true)); // false, because failed
    }
}
