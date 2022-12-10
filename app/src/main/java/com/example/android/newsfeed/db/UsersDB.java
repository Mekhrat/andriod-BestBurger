package com.example.android.newsfeed.db;

import com.example.android.newsfeed.model.User;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class UsersDB {

    private static Map<String, User> users = new HashMap<String, User>();

    public static User getUserByEmail(String email) {
        users.put("mekhrat_ashirbekov@mail.ru", new User("Mekhrat","Ashirbekov","Almaty 34","87714565768","mekhrat_ashirbekov@mail.ru","qwerty123"));
        return users.get(email);
    }

    public static boolean checkEmail(String email) {
        if (users.containsKey(email)) {
            return false;
        }
        return true;
    }

    public static void addUser(User user) {
        users.put(user.getEmail(),user);
    }

}
