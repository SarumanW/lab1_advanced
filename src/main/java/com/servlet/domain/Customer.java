package com.servlet.domain;

import java.util.UUID;

public class Customer {
    private String customerId;
    private String customerName;

    public Customer(String customerName) {
        this.customerId = UUID.randomUUID().toString();
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
