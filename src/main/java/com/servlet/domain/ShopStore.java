package com.servlet.domain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ShopStore {
    private static final int MAX_SIZE = 1000;
    private Map<Long, Object> purchases;
    private Map<Long, Object> items;
    private final Lock readLock;
    private final Lock writeLock;

    private static ShopStore shopStore = new ShopStore();

    public static ShopStore getInstance(){
        return shopStore;
    }

    private ShopStore() {
        purchases = new ConcurrentHashMap<>();
        items = new ConcurrentHashMap<>();
        fillItems();

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
        readLock = readWriteLock.readLock();
        writeLock = readWriteLock.writeLock();
    }

    public void putItem(Long key, Object value) {
        writeLock.lock();

        if(items.size() == MAX_SIZE)
            items.clear();

        try {
            items.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public Object getItem(Long key) {
        readLock.lock();

        try {
            return items.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public void removeItem(Long key) {
        writeLock.lock();

        try {
            items.remove(key);
        } finally {
            readLock.unlock();
        }
    }

    public Map<Long, Object> getAllItems(){
        return items;
    }

    private void fillItems(){
        for(long i = 0; i<100; i++){
            items.put(i, new Item(i, "item - " + i, i*10, "default supplier"));
        }
    }
}
