package com.servlet.domain;

import java.util.UUID;

public class Item {
    private String itemId;
    private String name;
    private int price;
    private String supplier;
    private int count;

    Item(String itemId, String name, int price, String supplier, int count) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.supplier = supplier;
        this.count = count;
    }

    Item(String name, int price, String supplier, int count) {
        this.itemId = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.supplier = supplier;
        this.count = count;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
