/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * auto generated
 *
 * @since 2019-08-27
 */
public class TimerVsScheduleExecutorServiceTest {
    public static void main(String[] args) {
        AtomicReference<String> reference = new AtomicReference<>("adsf");
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        long value = 10;
        executor.schedule(() -> {
            reference.set(null);
            executor.shutdownNow();
            System.out.println(reference.get());
        }, value, TimeUnit.SECONDS);

            reference.set("adsfasdf");

        Timer timer = new Timer(true);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                reference.set(null);
                this.cancel();
                System.out.println(reference.get());
            }
        };
        timer.schedule(timerTask, value * 1000);
    }
}
