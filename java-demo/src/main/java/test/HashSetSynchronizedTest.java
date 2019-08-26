/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package test;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executors;

/**
 * auto generated
 *
 * @since 2019-08-25
 */
public class HashSetSynchronizedTest {
    public static void main(String[] args) {
        Set<String> receivedShards = Sets.newConcurrentHashSet();
//        Set<String> receivedShards = new HashSet<>();
//        Set<String> receivedShards = Collections.synchronizedSet(new HashSet<>());

        final Object mutex = new Object();
        Runnable runnable = () -> {
            Set<String> sets = new HashSet<>();
                sets.addAll(receivedShards);
                receivedShards.clear();
        };

        // add data
        Executors.newSingleThreadExecutor().execute(() -> {
            while (true) {
                    receivedShards.add(UUID.randomUUID().toString());
            }
        });

        Executors.newSingleThreadExecutor().execute(() -> {
            while (true) {
                try {
                    runnable.run();
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
