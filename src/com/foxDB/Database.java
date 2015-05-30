package com.foxDB;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static com.foxDB.Persistor.readDbFromFile;
import static com.foxDB.Persistor.saveDbToFile;

public class Database implements IDatabase
{

    private final Path dbLocation = Paths.get(System.getProperty("user.home"), "development/foxDB", "db");

    private final Map<String, String> db = new HashMap<>();

    @Override
    public void init()
    {
        boolean exists = Files.exists(dbLocation);
        boolean isReadWritable = Files.isReadable(dbLocation) && Files.isWritable(dbLocation);
        if (exists && isReadWritable)
        {
            db.putAll(readDbFromFile(dbLocation));
        }
    }


    @Override
    public void put(String key, String value)
    {
        db.put(key, value);
    }


    @Override
    public String get(String key)
    {
        return db.get(key);
    }

    @Override
    public void close()
    {
        saveDbToFile(dbLocation, db);
    }

}
