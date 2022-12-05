package com.example.android.newsfeed.db;

import com.example.android.newsfeed.model.Burger;

import java.util.ArrayList;
import java.util.List;

public class OrdersDB {
    private static List<Burger> orders = new ArrayList<>();

    public static void addOrder(Burger burger) {
        orders.add(burger);
    }

    public static List<Burger> getOrders() {
        return orders;
    }
}
