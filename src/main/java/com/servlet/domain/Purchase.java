package com.servlet.domain;

import java.util.ArrayList;
import java.util.UUID;

public class Purchase {
    private String purchaseId;
    private Customer customer;
    private ArrayList<Item> items;

    public Purchase(Customer customer, ArrayList<Item> items) {
        this.purchaseId = UUID.randomUUID().toString();
        this.customer = customer;
        this.items = items;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseId='" + purchaseId + '\'' +
                ", customer='" + customer.getCustomerName() + '\'' +
                ", items=" + items +
                '}';
    }
}
