package com.rbnico.repositories;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.rbnico.MongoUtility;
import org.bson.Document;
import com.rbnico.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.mongodb.client.model.Filters.*;

public class StudentsRepository implements Repository <Student, Integer>{

    MongoCollection<Document> collection = MongoUtility.getDatabase().getCollection("students");


    @Override
    public boolean create(Student entity) {
        boolean result = false;
        try {
            collection.insertOne(toDocument(entity));
            result = true;
        } catch(Exception e){
            System.out.println(e.getMessage());
        };
        return result;
    }

    @Override
    public Student find(Integer id) {
        return fromDocument(
                Objects.requireNonNull(collection
                        .find(eq("_id", id))
                        .first()));
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();

        FindIterable<Document> all = collection.find();
        for(Document d : all)
        {
            students.add(fromDocument(d));
        }
        return students;
    }

    @Override
    public boolean update(Student newEntity) {
        Student oldEntity = find(newEntity.getId());
        return collection.replaceOne(toDocument(oldEntity), toDocument(newEntity)).wasAcknowledged();
    }

    @Override
    public boolean delete(Integer id) {
        return collection.deleteOne(eq("_id", id)).wasAcknowledged();
    }

    @Override
    public Student findBy(Object i, Object o) {
        return fromDocument(
                Objects.requireNonNull(collection
                        .find(and(gte("age", (Integer)i), lte("age", (Integer)o)))
                        .first()));
    }


    @Override
    public Document toDocument(Student entity) {
        Document document = new Document()
                .append("_id", entity.getId())
                .append("name", entity.getName())
                .append("lastname", entity.getLastname())
                .append("age", entity.getAge());
        return document;
    }

    @Override
    public Student fromDocument(Document document) {
        Student student = new Student();

        student.setId(document.getInteger("_id"));
        student.setName(document.getString("name"));
        student.setLastname(document.getString("lastname"));
        student.setAge(document.getInteger("age"));
        return student;
    }


}
