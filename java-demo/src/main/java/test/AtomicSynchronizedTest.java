/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;

/**
 * auto generated
 *
 * @since 2019-08-25
 */
public class AtomicSynchronizedTest {
        Instant instantAtomicReference = Instant.now();
    public static void main(String[] args) {
        AtomicSynchronizedTest atomicSynchronizedTest = new AtomicSynchronizedTest();
        Executors.newSingleThreadExecutor().execute(()->{
            while (true) {
                Instant last = atomicSynchronizedTest.instantAtomicReference;
                System.out.println(Duration.between(last, Instant.now()).getNano());
            }
        });

        Executors.newSingleThreadExecutor().execute(()->{
            while (true) {
                atomicSynchronizedTest.instantAtomicReference = Instant.now();
            }
        });
    }
}
