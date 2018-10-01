package com.servlet.domain;

public class Item {
    private Long itemId;
    private String name;
    private double price;
    private String supplier;

    Item(Long itemId, String name, double price, String supplier) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.supplier = supplier;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
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

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
