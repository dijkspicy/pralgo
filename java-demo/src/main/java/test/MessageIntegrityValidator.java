/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * auto generated
 *
 * @since 2019/8/19
 */
public class MessageIntegrityValidator {
    private static volatile MessageDigest messageDigest;

    static {
        try {
            setDefaultAlgorithm("MD5");
        } catch (NoSuchAlgorithmException ignored) {
        }
    }

    public static void setDefaultAlgorithm(String algorithm) throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance(algorithm);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        byte[] out = messageDigest.digest("asdfasdfasdf".getBytes());
        System.out.println(byte2hex(out));
    }

    //二行制转字符串
    static String byte2hex(byte[] bytes) {
        StringBuilder hexBuilder = new StringBuilder();
        for (byte oneByte : bytes) {
            hexBuilder.append(String.format("%02X", oneByte));
        }
        return hexBuilder.toString();
    }
}
