package com.foxDB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DBFile implements IDBFile
{

    private final RandomAccessFile raf;

    public DBFile(File path) throws FileNotFoundException
    {
        raf = new RandomAccessFile(path, "rws");
    }

    @Override
    public byte[] read(String path, int offset, int length) throws IOException
    {
        byte[] bytes = new byte[length];
        raf.seek(offset);
        raf.readFully(bytes);
        return bytes;
    }

    @Override
    public void write(String path, int offset, byte[] data) throws IOException
    {
        raf.seek(offset);
        raf.write(data);
    }

    @Override
    public void append(String path, byte[] data) throws IOException
    {
        long length = raf.length();
        raf.seek(length);
        raf.write(data);
    }

    @Override
    public void close() throws IOException
    {
        raf.close();
    }

}
