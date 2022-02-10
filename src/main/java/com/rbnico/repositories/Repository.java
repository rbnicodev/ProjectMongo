package com.rbnico.repositories;

import org.bson.Document;

import java.util.List;

public interface Repository<E, I> {
    boolean create(E entity);
    E find(I id);
    List<E> findAll();
    boolean update(E newEntity);
    boolean delete(I id);
    E findBy(Object i, Object o);
    Document toDocument(E entity);
    E fromDocument(Document document);
}
