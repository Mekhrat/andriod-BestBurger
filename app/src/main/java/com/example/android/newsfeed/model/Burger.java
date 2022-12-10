package com.example.android.newsfeed.model;

import java.util.Objects;

public class Burger {
    private String name;
    private int price;
    private String descryption;
    private int photo;
    private int count;

    public Burger(String name, int price, String descryption, int photo) {
        this.name = name;
        this.price = price;
        this.descryption = descryption;
        this.photo = photo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Burger burger = (Burger) o;
        return price == burger.price && photo == burger.photo && count == burger.count && Objects.equals(name, burger.name) && Objects.equals(descryption, burger.descryption);
    }

    @Override
    public String toString() {
        return "Burger{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", descryption='" + descryption + '\'' +
                ", photo=" + photo +
                ", count=" + count +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, descryption, photo, count);
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
