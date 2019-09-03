/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package test;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * auto generated
 *
 * @since 2019-09-02
 */
public class Java8TimeTest {
    public static void main(String[] args) {
        System.out.println(LocalDateTime
            .now()
            .atZone(ZoneOffset.UTC)
            .toInstant()
//            .toEpochMilli()
        );
        System.out.println(LocalDateTime
            .now()
            .atZone(ZoneOffset.of("+8"))
            .toInstant()
//            .toEpochMilli()
        );
        System.out.println(Instant.now()
            .atZone(ZoneOffset.UTC)
            .toInstant()
//            .toEpochMilli()
        );
        long time = System.currentTimeMillis();
        System.out.println(time);
        System.out.println(Instant.ofEpochMilli(time));
    }
}
