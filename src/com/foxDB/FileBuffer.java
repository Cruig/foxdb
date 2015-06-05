package com.foxDB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.file.Paths;

/**
 * Created by jcf on 5/30/15.
 */
public class FileBuffer
{
    public static RandomAccessFile get(String path, String mode) throws FileNotFoundException
    {
        File file = Paths.get(path).toFile();
        return new RandomAccessFile(file, mode);
    }
}
