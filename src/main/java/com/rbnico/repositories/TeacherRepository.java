package com.rbnico.repositories;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.rbnico.MongoUtility;
import com.rbnico.models.TeacherModel;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.rbnico.MongoUtility.getDb;
import static com.rbnico.MongoUtility.getClient;
import static com.mongodb.client.model.Filters.eq;

public class TeacherRepository implements Repository<TeacherModel, String> {

    private String collection = "teachers";

    @Override
    public boolean insertOne(TeacherModel entity) {
        getCollection().insertOne(entity);
//        getClient().close();
        return true;
    }

    @Override
    public boolean insertMany(List<TeacherModel> entities) throws MongoException {
        getCollection().insertMany(entities);
        getClient().close();
        return true;
    }


    @Override
    public boolean update(TeacherModel entity) {
        getCollection().replaceOne(eq("name", entity.getName()), entity);
        getClient().close();
        return true;
    }

    @Override
    public TeacherModel find(String name) {
        TeacherModel teacher = (TeacherModel) getCollection().find(new Document("name", name));
//        getClient().close();
        return teacher;
    }

    @Override
    public List<TeacherModel> findAll() {

        List<TeacherModel> teachers = (List<TeacherModel>) getCollection().find().into(new ArrayList<>());
        getClient().close();
        return teachers;
    }

    @Override
    public boolean delete(String name) {
        getCollection().deleteOne(eq("name", name));
        getClient().close();
        return true;

    }

    @Override
    public Document toDocument(TeacherModel entity) {
        Document doc = new Document()
                .append("name", entity.getName())
                .append("last_name", entity.getLastName());
        return doc;
    }

    @Override
    public TeacherModel fromDocument(Document doc) {
        return null;
    }

    @Override
    public MongoCollection getCollection()
    {
        MongoCollection<TeacherModel> teachersCollection = getDb().getCollection(collection, TeacherModel.class);
        return teachersCollection;
    }

}
