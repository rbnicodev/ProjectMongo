package com.rbnico.repositories;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.rbnico.models.StudentModel;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.rbnico.MongoUtility.getDb;
import static com.rbnico.MongoUtility.getClient;
import static com.mongodb.client.model.Filters.eq;

public class StudentRepository implements Repository<StudentModel, String> {

    private final String collection = "students";

    @Override
    public boolean insertOne(StudentModel entity) {
        getCollection().insertOne(entity);
        getClient().close();
        return true;
    }

    @Override
    public boolean insertMany(List<StudentModel> entities) throws MongoException {
        getCollection().insertMany(entities);
        getClient().close();
        return true;
    }


    @Override
    public boolean update(StudentModel entity) {
        getCollection().replaceOne(eq("name", entity.getName()), entity);
        getClient().close();
        return true;
    }

    @Override
    public StudentModel find(String name) {
        StudentModel student = getCollection().find(eq("name", name), StudentModel.class).first();
        getClient().close();
        return student;
    }

    @Override
    public List<StudentModel> findAll() {

        List<StudentModel> students = getCollection().find().into(new ArrayList<>());
        getClient().close();
        return students;
    }

    @Override
    public boolean delete(String name) {
        getCollection().deleteOne(eq("name", name));
        getClient().close();
        return true;
    }

    @Override
    public Document toDocument(StudentModel entity) {
        Document doc = new Document()
                .append("name", entity.getName())
                .append("last_name", entity.getLastName())
                .append("age", entity.getAge());
        return doc;
    }

    @Override
    public StudentModel fromDocument(Document doc) {
        return null;
    }

    @Override
    public MongoCollection<StudentModel> getCollection() {
        MongoCollection<StudentModel> studentsCollection = getDb().getCollection(collection, StudentModel.class);
        return studentsCollection;
    }


}
