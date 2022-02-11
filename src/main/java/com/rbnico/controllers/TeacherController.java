package com.rbnico.controllers;

import com.rbnico.models.Teacher;
import com.rbnico.repositories.Repository;
import com.rbnico.repositories.StudentsRepository;
import com.rbnico.repositories.TeachersRepository;
import com.rbnico.repositories.TeachersRepositoryODB;

import java.util.ArrayList;
import java.util.List;

public class TeacherController implements Controller<String[], Integer>{

    //
    //REPOSITORIO QUE USA MONGODB
    //
    Repository repository = new TeachersRepository();

    //
    //REPOSITORIO QUE USA OBJECTDB
    //
//    Repository repository = new TeachersRepositoryODB();

    @Override
    public void create(String[] entity) {
        repository.create(fromStringArray(entity));
    }

    @Override
    public String[] find(Integer id) {
        return toStringArray((Teacher)repository.find(id));
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
        List<Teacher> teachers = repository.findAll();
        String[][] entities = new String[teachers.size()][4];
        int i = 0;
        for(Teacher t : teachers)
        {
            entities[i] = toStringArray(t);
            i++;
        }
        return entities;
    }

    @Override
    public String[][] findBy(String[] minMax) {
        List<Teacher> teachers = repository.findBy(Integer.parseInt(minMax[0]), Integer.parseInt(minMax[1]));
        String[][] entities = new String[teachers.size()][4];
        int i = 0;
        teachers.forEach(teacher -> {
            entities[i] = toStringArray(teacher);
        });
        return entities;
    }

    String[] toStringArray(Teacher teacher) {
        String[] entity = new String[4];
        entity[0] = String.valueOf(teacher.getId());
        entity[1] = teacher.getName();
        entity[2] = String.valueOf(teacher.getSegSocial());
        entity[3] = String.valueOf(teacher.getSalary());

        return entity;
    }

    Teacher fromStringArray(String[] entity) {
        Teacher teacher = new Teacher();
        try {
            teacher.setId(Integer.parseInt(entity[0]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        teacher.setName(entity[1]);
        try {
            teacher.setSegSocial(Integer.parseInt(entity[2]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            teacher.setSalary(Double.parseDouble(entity[3]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return teacher;
    }
}
