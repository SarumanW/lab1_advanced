package com.servlet.domain;

import java.util.UUID;

public class Item implements Cloneable{
    private String itemId;
    private String name;
    private int price;
    private String supplier;
    private int count;

    @Override
    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return new Item(this.getItemId(), this.getName(), (int) this.getPrice(),this.getSupplier(), this.getCount());
        }
    }

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

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", supplier='" + supplier + '\'' +
                ", count=" + count +
                '}';
    }
}
