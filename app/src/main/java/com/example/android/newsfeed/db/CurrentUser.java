package com.example.android.newsfeed.db;

import com.example.android.newsfeed.model.User;

public class CurrentUser {
    private static User currentUser;

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}
