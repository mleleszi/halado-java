package com.example;

public interface CacheWrite {
    void set(String name, int value);
    void delete(String name);
    void clear();
}
