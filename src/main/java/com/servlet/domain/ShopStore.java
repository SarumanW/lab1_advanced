package com.servlet.domain;

import org.apache.log4j.Logger;

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
    private Map<String, Customer> blackList;
    private final Lock readLock;
    private final Lock writeLock;

    final static Logger logger = Logger.getLogger(ShopStore.class);

    private static ShopStore shopStore = new ShopStore();

    public static ShopStore getInstance(){
        return shopStore;
    }

    private ShopStore() {
        purchases = new ConcurrentHashMap<>();
        items = new ConcurrentHashMap<>();
        customers = new ConcurrentHashMap<>();
        blackList = new ConcurrentHashMap<>();

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
        readLock = readWriteLock.readLock();
        writeLock = readWriteLock.writeLock();

        fillItems();
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
            Item item = (Item) getItem(itemIds[i]).clone();
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
            customers.put(value.getCustomerId(), value);
        } finally {
            writeLock.unlock();
        }
    }

    public void putCustomerToBlackList(Customer value) {
        writeLock.lock();

        if(blackList.size() == MAX_SIZE)
            blackList.clear();

        try {
            blackList.put(value.getCustomerName(), value);
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

    public Map<String, Customer> getAllBlackList(){
        return blackList;
    }

    private void fillItems(){
        for(int i = 0; i<10; i++){
            String uuid = UUID.randomUUID().toString();
            items.put(uuid, new Item(uuid, "item " + i,
                    ThreadLocalRandom.current().nextInt(10, 100), "default supplier", 10));

            ArrayList<Item> items = new ArrayList<>();
            items.add(new Item("item - " + i, ThreadLocalRandom.current().nextInt(10, 100), "default supplier", 5));
            items.add(new Item("item - " + i + 1, ThreadLocalRandom.current().nextInt(10, 100), "default supplier", 5));

            Customer customer = new Customer("customer - " + i);
            putCustomer(customer);

            Purchase purchase = new Purchase(customer, items);
            purchases.put(purchase.getPurchaseId(), purchase);
        }

    }
}
