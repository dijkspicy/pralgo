/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package test;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * auto generated
 *
 * @since 2019-08-31
 */
public class JsonTest {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
            .setDateFormat(new SimpleDateFormat("HH:mm:ss 'CST'"));

        System.out.println(objectMapper.writeValueAsString(new TestDate()));

        System.out.println(objectMapper.readValue("{\"test\":3,\"date\":\"16:40:21 CST\"}", TestDate.class).date);

        TestDate out = JSON.parseObject("{\"test\":3,\"date\":\"2013-08\"}", TestDate.class);
        System.out.println(out.date);
    }

    static class TestDate {
        public int test = 3;
        public Timestamp date = new Timestamp(1);
    }
}
