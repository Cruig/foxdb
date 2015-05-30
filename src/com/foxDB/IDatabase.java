package com.foxDB;

interface IDatabase {
    void init();

    void put(String key, String value);
    String get(String key);

    void close();
}
