package com.example.android.newsfeed.db;

import java.util.HashMap;
import java.util.Map;

public class CodeDB {
    private static Map<String, String> codes = new HashMap<>();

    public static void addCode(String email, String code) {
        codes.put(email, code);
    }

    public static String getCode(String email) {
        return codes.get(email);
    }
}
