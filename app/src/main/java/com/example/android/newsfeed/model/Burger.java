package com.example.android.newsfeed.model;

public class Burger {
    private String name;
    private int price;
    private String descryption;
    private int photo;

    public Burger(String name, int price, String descryption, int photo) {
        this.name = name;
        this.price = price;
        this.descryption = descryption;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescryption() {
        return descryption;
    }

    public void setDescryption(String descryption) {
        this.descryption = descryption;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
