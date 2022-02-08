package com.rbnico;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoUtility {
    private static MongoClient client;

    private MongoUtility(){};

    public static MongoClient getClient() {
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(EnvironmentVars.url)
                .codecRegistry(codecRegistry)
                .build();

        client = MongoClients.create(clientSettings);
        return client;
    }

    public static MongoDatabase getDb()
    {
        return getClient().getDatabase(EnvironmentVars.stringDb);
    }
}
