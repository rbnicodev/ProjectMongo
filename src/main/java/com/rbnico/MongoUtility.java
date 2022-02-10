package com.rbnico;

import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;

public class MongoUtility {
    private static MongoClient client;

    private MongoUtility(){}

    public static MongoDatabase getDatabase() {
        if(client == null) client = new MongoClient("localhost", 27017);
        return client.getDatabase("simply_Teaching");
    }

    public static void close() {
        if(client != null) client.close();
    }
}
