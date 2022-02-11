package com.rbnico.repositories;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.rbnico.MongoUtility;
import com.rbnico.models.Student;
import com.rbnico.models.Teacher;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Filters.lte;

public class TeachersRepository implements Repository<Teacher, Integer>{

    MongoCollection<Document> collection = MongoUtility.getDatabase().getCollection("teachers");
    StudentsRepository studentsRepository = new StudentsRepository();

    @Override
    public boolean create(Teacher entity) {
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
    public Teacher find(Integer id) {
        return fromDocument(
                Objects.requireNonNull(collection
                        .find(eq("_id", id))
                        .first()));
    }

    @Override
    public List<Teacher> findAll() {
        List<Teacher> teachers = new ArrayList<>();

        FindIterable<Document> all = collection.find();
        for(Document d : all)
        {
            teachers.add(fromDocument(d));
        }
        return teachers;
    }

    @Override
    public boolean update(Teacher newEntity) {
        try {
            delete(newEntity.getId());
            create(newEntity);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        return collection.deleteOne(eq("_id", id)).wasAcknowledged();
    }

    @Override
    public List<Teacher> findBy(Object i, Object o) {
        List<Teacher> teachers = new ArrayList<>();
        collection.find(and(gte("salary", (Integer)i), lte("salary", (Integer)o))).forEach((Block<? super Document>) document -> teachers.add(fromDocument(document)));

        return teachers;
    }


    public Document toDocument(Teacher entity) {
        List<Document> students = new ArrayList<>();
        for(Student s : entity.getStudents()) {
            students.add(studentsRepository.toDocument(s));
        }
        return new Document()
                .append("_id", entity.getId())
                .append("name", entity.getName())
                .append("lastname", entity.getLastname())
                .append("seg_social", entity.getSegSocial())
                .append("salary", entity.getSalary())
                .append("students", students);
    }

    public Teacher fromDocument(Document document) {

        Teacher teacher = new Teacher();
        teacher.setId(document.getInteger("_id"));
        teacher.setName(document.getString("name"));
        teacher.setLastname(document.getString("lastname"));
        teacher.setSegSocial(document.getInteger("seg_social"));
        teacher.setSalary(document.getDouble("salary"));
        for(Document student : document.getList("students", Document.class)) {
            teacher.getStudents().add(studentsRepository.fromDocument(student));
        }
        return teacher;
    }
}
