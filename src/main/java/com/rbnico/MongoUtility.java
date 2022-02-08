package com.rbnico;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class MongoUtility {
    private static MongoClient client;

    private MongoUtility(){};

    public static MongoClient getClient() {
        if(client == null) {
            CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                    CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
            client = MongoClients.create(
                    MongoClientSettings.builder()
                            .applyConnectionString(EnvironmentVars.url)
                            .codecRegistry(pojoCodecRegistry)
                            .build());
        }
        return client;
    }

    public static MongoDatabase getDb()
    {
        return getClient().getDatabase(EnvironmentVars.stringDb);
    }
}
