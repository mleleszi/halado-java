package com.example;

import java.util.HashMap;
import java.util.Map;

public class Cache implements CacheRead, CacheWrite {

    Map<String, Integer> values = new HashMap<>();

    @Override
    public int get(String name) {
        return values.get(name);
    }

    @Override
    public boolean isEmpty() {
        return values.isEmpty();
    }

    @Override
    public void set(String name, int value) {
        values.put(name, value);
    }

    @Override
    public void delete(String name) {
        values.remove(name);
    }

    @Override
    public void clear() {
        values.clear();
    }
}
