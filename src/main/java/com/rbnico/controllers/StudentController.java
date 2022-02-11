package com.rbnico.controllers;

import com.rbnico.models.Student;
import com.rbnico.repositories.Repository;
import com.rbnico.repositories.StudentsRepository;
import com.rbnico.repositories.StudentsRepositoryODB;

import java.util.List;

public class StudentController implements Controller<String[], Integer>{

    //
    //REPOSITORIO QUE USA MONGODB
    //
    Repository repository = new StudentsRepository();

    //
    //REPOSITORIO QUE USA OBJECTDB
    //
//    Repository repository = new StudentsRepositoryODB();

    @Override
    public void create(String[] entity) {
        repository.create(fromStringArray(entity));
    }

    @Override
    public String[] find(Integer id) {
        return toStringArray((Student)repository.find(id));
    }

    @Override
    public void update(String[] entity) {
        repository.update(fromStringArray(entity));
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public String[][] findAll() {
        List<Student> students = repository.findAll();
        String[][] entities = new String[students.size()][4];
        int i = 0;
        for(Student s : students)
        {
            entities[i] = toStringArray(s);
            i++;
        }
        return entities;
    }

    @Override
    public String[][] findBy(String[] minMax) {
        List<Student> students = repository.findBy(Integer.parseInt(minMax[0]), Integer.parseInt(minMax[1]));
        String[][] entities = new String[students.size()][4];
        int i = 0;
        students.forEach(student -> {
            entities[i] = toStringArray(student);
        });
        return entities;
    }

    String[] toStringArray(Student student) {
        String[] entity = new String[4];
        entity[0] = String.valueOf(student.getId());
        entity[1] = student.getName();
        entity[2] = student.getLastname();
        entity[3] = String.valueOf(student.getAge());

        return entity;
    }

    Student fromStringArray(String[] entity) {
        Student student = new Student();
        try {
            student.setId(Integer.parseInt(entity[0]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        student.setName(entity[1]);
        student.setLastname(entity[2]);
        try {
            student.setAge(Integer.parseInt(entity[3]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return student;
    }
}
