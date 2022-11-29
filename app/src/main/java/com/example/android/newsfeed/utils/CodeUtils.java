package com.example.android.newsfeed.utils;

import java.util.Random;

public class CodeUtils {

    public static String generateCode() {
        Random random = new Random();
        String code = String.valueOf(random.nextInt(10));
        return code + random.nextInt(100000);
    }
}
