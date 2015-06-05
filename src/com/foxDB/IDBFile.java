package com.foxDB;

import java.io.IOException;

interface IDBFile
{
    byte[] read(String path, int offset, int length) throws IOException;
    void write(String path, int offset, byte[] data) throws IOException;
    void append(String path, byte[] data) throws IOException;

    void close() throws IOException;
}
