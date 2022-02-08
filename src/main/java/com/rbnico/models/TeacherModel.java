package com.rbnico.models;


import java.util.ArrayList;
import java.util.List;

public class TeacherModel extends EntityModel {
    private String name;
    private String lastName;
    private List<StudentModel> students = new ArrayList<>();

    public TeacherModel() {
    }

    public TeacherModel(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public List<StudentModel> getStudents() {
        return students;
    }

    public void setStudents(List<StudentModel> students) {
        this.students = students;
    }

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
