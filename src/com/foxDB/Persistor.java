package com.foxDB;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jcf on 5/29/15.
 */
public class Persistor
{

    static HashMap<String, String> readDbFromFile(Path dbLocation)
    {

        try (FileInputStream fileIn = new FileInputStream(dbLocation.toFile()))
        {
            try (ObjectInputStream in = new ObjectInputStream(fileIn))
            {
                return (HashMap) in.readObject();
            }

        } catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    static void saveDbToFile(Path dbLocation, Map<String, String> db)
    {
        try (FileOutputStream fileOut = new FileOutputStream(dbLocation.toFile()))
        {
            try (ObjectOutputStream out = new ObjectOutputStream(fileOut))
            {
                out.writeObject(db);
            }
        } catch (IOException i)
        {
            i.printStackTrace();
        }
    }

}
