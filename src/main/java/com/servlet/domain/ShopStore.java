package com.servlet.domain;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ShopStore {
    private static final int MAX_SIZE = 1000;
    private Map<String, Purchase> purchases;
    private Map<String, Item> items;
    private Map<String, Customer> customers;
    private final Lock readLock;
    private final Lock writeLock;

    private static ShopStore shopStore = new ShopStore();

    public static ShopStore getInstance(){
        return shopStore;
    }

    private ShopStore() {
        purchases = new ConcurrentHashMap<>();
        items = new ConcurrentHashMap<>();
        customers = new ConcurrentHashMap<>();
        fillItems();

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
        readLock = readWriteLock.readLock();
        writeLock = readWriteLock.writeLock();
    }

    public void putItem(Item value) {
        writeLock.lock();

        if(items.size() == MAX_SIZE)
            items.clear();

        try {
            items.put(value.getItemId(), value);
        } finally {
            writeLock.unlock();
        }
    }

    private Item getItem(String key) {
        readLock.lock();

        try {
            return items.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public ArrayList<Item> getArrayOfItemsByIds(String[] itemIds, String[] counts){
        ArrayList<Item> items = new ArrayList<>();
        for(int i = 0; i < itemIds.length; i++){
            Item item = getItem(itemIds[i]);
            item.setCount(Integer.valueOf(counts[i]));
            items.add(item);
        }
        return items;
    }

    public void putPurchase(Purchase value) {
        writeLock.lock();

        for(Item item : value.getItems()){
            Item _item = getItem(item.getItemId());
            _item.setCount(_item.getCount() - item.getCount());
        }

        if(purchases.size() == MAX_SIZE)
            purchases.clear();

        try {
            purchases.put(value.getPurchaseId(), value);
        } finally {
            writeLock.unlock();
        }
    }

    public Customer getCustomer(String key) {
        readLock.lock();

        try {
            return customers.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public void putCustomer(Customer value) {
        writeLock.lock();

        if(customers.size() == MAX_SIZE)
            customers.clear();

        try {
            customers.put(value.getCustomerName(), value);
        } finally {
            writeLock.unlock();
        }
    }

    public Map<String, Item> getAllItems(){
        return items;
    }

    public Map<String, Purchase> getAllPurchases(){
        return purchases;
    }

    public Map<String, Customer> getAllCustomers(){
        return customers;
    }

    private void fillItems(){
        for(long i = 0; i<10; i++){
            String uuid = UUID.randomUUID().toString();
            items.put(uuid, new Item(uuid, "item " + i, ThreadLocalRandom.current().nextInt(10, 100), "default supplier", 10));
        }
    }
}
