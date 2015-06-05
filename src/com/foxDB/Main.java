package com.foxDB;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException
    {

        String test1 = "one";
        String test2 = "two";

        byte[] bytes1 = test1.getBytes();
        byte[] bytes2 = test2.getBytes();


        Path dbLocation = Paths.get(System.getProperty("user.home"), "development/foxDB", "db");
//        try (FileOutputStream fileOut = new FileOutputStream(dbLocation.toFile()))
//        {
//            try (ObjectOutputStream out = new ObjectOutputStream(fileOut))
//            {
//                out.write(bytes1);
//            }
//        } catch (IOException i)
//        {
//            i.printStackTrace();
//        }

        DBFile fileWriter = new DBFile(dbLocation.toFile());

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 10; i++)
        {
            stringBuffer.append(String.valueOf(i));
        }

        String myStr = stringBuffer.toString();


//        persister.write(dbLocation.toString(), 0, myStr.getBytes());
        fileWriter.append(dbLocation.toString(), "aa".getBytes());
        File file = new File(dbLocation.toString());
        byte[] read = fileWriter.read(dbLocation.toString(), 0, (int)file.length());

        System.out.println(new String(read));
        System.out.println(new String(read).equals(myStr+"aaaaaa"));
//        System.out.println(new String(read)+"aa");
//        persister.append(dbLocation.toString(), bytes2);

    }

}



