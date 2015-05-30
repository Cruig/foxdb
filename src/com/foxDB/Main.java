package com.foxDB;

public class Main {

    public static void main(String[] args) {
        IDatabase db = new Database();
        db.init();

//        for (int i = 0; i < 10_000_000; i++)
//        {
//            db.put(Integer.toString(i), Integer.toString(i));
//        }

        db.get("1");
        db.close();
    }

}



