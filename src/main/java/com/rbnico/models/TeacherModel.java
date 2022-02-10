package com.rbnico.models;


import org.bson.codecs.pojo.annotations.BsonId;

import java.util.ArrayList;
import java.util.List;

public class TeacherModel extends EntityModel {
    @BsonId
    private Long id;
    private String name;
    private String lastName;
    private List<StudentModel> students = new ArrayList<>();

    public TeacherModel() {
    }

    public TeacherModel(Long id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public List<StudentModel> getStudents() {
        return students;
    }

    public void setStudents(List<StudentModel> students) { this.students = students; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
