package com.rbnico.repositories;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.rbnico.EnvironmentVars;
import org.bson.Document;

import java.util.List;

public interface Repository<E, I>{

    String db = EnvironmentVars.stringDb;

    boolean insertOne(E entity) throws MongoException;
    boolean insertMany(List<E> entities) throws MongoException;
    boolean update(E entity) throws MongoException;
    E find(I id) throws MongoException;
    List<E> findAll() throws MongoException;
    boolean delete(I id) throws MongoException;
    Document toDocument(E entity);
    E fromDocument(Document doc);
    MongoCollection<E> getCollection();
}
